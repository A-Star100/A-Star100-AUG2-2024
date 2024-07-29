package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList();

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    private static void generateArrangements(List<int[]> list, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    generateArrangements(list, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List<int[]> elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        for (int[] next : elementsArrangements) {
            boolean z = true;
            for (int i = 0; i < this.mSurfaceConfigList.size(); i++) {
                if (next[i] < list.size()) {
                    z &= this.mSurfaceConfigList.get(i).isSupported(list.get(next[i]));
                    if (!z) {
                        continue;
                        break;
                    }
                    surfaceConfigArr[next[i]] = this.mSurfaceConfigList.get(i);
                }
            }
            if (z) {
                return Arrays.asList(surfaceConfigArr);
            }
        }
        return null;
    }

    private List<int[]> getElementsArrangements(int i) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i, new int[i], 0);
        return arrayList;
    }
}
