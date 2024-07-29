package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList = new SparseArray<>();

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        this.mConstraintLayout = constraintLayout;
        load(context, i);
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        State state = (State) (i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2));
        return (this.mCurrentConstraintNumber == -1 || !state.mVariants.get(this.mCurrentConstraintNumber).match(f, f2)) && this.mCurrentConstraintNumber != state.findMatch(f, f2);
    }

    public void updateConstraints(int i, float f, float f2) {
        ConstraintSet constraintSet;
        int i2;
        State state;
        int findMatch;
        ConstraintSet constraintSet2;
        int i3;
        int i4 = this.mCurrentStateId;
        if (i4 == i) {
            if (i == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(i4);
            }
            if ((this.mCurrentConstraintNumber == -1 || !state.mVariants.get(this.mCurrentConstraintNumber).match(f, f2)) && this.mCurrentConstraintNumber != (findMatch = state.findMatch(f, f2))) {
                if (findMatch == -1) {
                    constraintSet2 = this.mDefaultConstraintSet;
                } else {
                    constraintSet2 = state.mVariants.get(findMatch).mConstraintSet;
                }
                if (findMatch == -1) {
                    i3 = state.mConstraintID;
                } else {
                    i3 = state.mVariants.get(findMatch).mConstraintID;
                }
                if (constraintSet2 != null) {
                    this.mCurrentConstraintNumber = findMatch;
                    ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i3);
                    }
                    constraintSet2.applyTo(this.mConstraintLayout);
                    ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.mCurrentStateId = i;
        State state2 = this.mStateList.get(i);
        int findMatch2 = state2.findMatch(f, f2);
        if (findMatch2 == -1) {
            constraintSet = state2.mConstraintSet;
        } else {
            constraintSet = state2.mVariants.get(findMatch2).mConstraintSet;
        }
        if (findMatch2 == -1) {
            i2 = state2.mConstraintID;
        } else {
            i2 = state2.mVariants.get(findMatch2).mConstraintID;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
            return;
        }
        this.mCurrentConstraintNumber = findMatch2;
        ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i, i2);
        }
        constraintSet.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i, i2);
        }
    }

    static class State {
        int mConstraintID = -1;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f, float f2) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID = -1;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean match(float f, float f2) {
            if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1 = 0
        L_0x000d:
            r2 = 1
            if (r0 == r2) goto L_0x00a8
            if (r0 == 0) goto L_0x0096
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x0099
        L_0x0017:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x004d;
                case 80204913: goto L_0x0043;
                case 1382829617: goto L_0x0039;
                case 1657696882: goto L_0x002f;
                case 1901439077: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x0024:
            goto L_0x0057
        L_0x0025:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r4 == 0) goto L_0x0057
            r4 = r6
            goto L_0x0058
        L_0x002f:
            java.lang.String r4 = "layoutDescription"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r4 == 0) goto L_0x0057
            r4 = 0
            goto L_0x0058
        L_0x0039:
            java.lang.String r4 = "StateSet"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r4 == 0) goto L_0x0057
            r4 = r2
            goto L_0x0058
        L_0x0043:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r4 == 0) goto L_0x0057
            r4 = r3
            goto L_0x0058
        L_0x004d:
            java.lang.String r4 = "ConstraintSet"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r4 == 0) goto L_0x0057
            r4 = r5
            goto L_0x0058
        L_0x0057:
            r4 = -1
        L_0x0058:
            if (r4 == 0) goto L_0x0099
            if (r4 == r2) goto L_0x0099
            if (r4 == r3) goto L_0x0089
            if (r4 == r6) goto L_0x007e
            if (r4 == r5) goto L_0x007a
            java.lang.String r2 = "ConstraintLayoutStates"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            java.lang.String r4 = "unknown tag "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r3.append(r0)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            java.lang.String r0 = r3.toString()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            android.util.Log.v(r2, r0)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x0099
        L_0x007a:
            r7.parseConstraintSet(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x0099
        L_0x007e:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0099
            r1.add(r0)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x0099
        L_0x0089:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r0 = r7.mStateList     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r2 = r1.mId     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r0.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x0099
        L_0x0096:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x0099:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x000d
        L_0x009f:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00a8
        L_0x00a4:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("id".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    } else {
                        i = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i, constraintSet);
                return;
            }
        }
    }
}
