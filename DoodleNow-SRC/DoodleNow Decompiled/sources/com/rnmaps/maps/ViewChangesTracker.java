package com.rnmaps.maps;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;

public class ViewChangesTracker {
    private static ViewChangesTracker instance;
    private final long fps = 40;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */
    public boolean hasScheduledFrame = false;
    /* access modifiers changed from: private */
    public final LinkedList<MapMarker> markers = new LinkedList<>();
    private final LinkedList<MapMarker> markersToRemove = new LinkedList<>();
    /* access modifiers changed from: private */
    public final Runnable updateRunnable = new Runnable() {
        public void run() {
            ViewChangesTracker.this.update();
            if (ViewChangesTracker.this.markers.size() > 0) {
                ViewChangesTracker.this.handler.postDelayed(ViewChangesTracker.this.updateRunnable, 40);
            } else {
                ViewChangesTracker.this.hasScheduledFrame = false;
            }
        }
    };

    private ViewChangesTracker() {
    }

    static ViewChangesTracker getInstance() {
        if (instance == null) {
            synchronized (ViewChangesTracker.class) {
                instance = new ViewChangesTracker();
            }
        }
        return instance;
    }

    public void addMarker(MapMarker mapMarker) {
        this.markers.add(mapMarker);
        if (!this.hasScheduledFrame) {
            this.hasScheduledFrame = true;
            this.handler.postDelayed(this.updateRunnable, 40);
        }
    }

    public void removeMarker(MapMarker mapMarker) {
        this.markers.remove(mapMarker);
    }

    public boolean containsMarker(MapMarker mapMarker) {
        return this.markers.contains(mapMarker);
    }

    public void update() {
        Iterator it = this.markers.iterator();
        while (it.hasNext()) {
            MapMarker mapMarker = (MapMarker) it.next();
            if (!mapMarker.updateCustomForTracking()) {
                this.markersToRemove.add(mapMarker);
            }
        }
        if (this.markersToRemove.size() > 0) {
            this.markers.removeAll(this.markersToRemove);
            this.markersToRemove.clear();
        }
    }
}
