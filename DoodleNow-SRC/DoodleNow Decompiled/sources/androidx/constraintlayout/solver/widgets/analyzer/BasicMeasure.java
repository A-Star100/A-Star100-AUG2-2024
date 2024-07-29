package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer2) {
        int size = constraintWidgetContainer2.mChildren.size();
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    measure(measurer, constraintWidget, false);
                    if (constraintWidgetContainer2.mMetrics != null) {
                        constraintWidgetContainer2.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i, int i2) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i);
        constraintWidgetContainer2.setHeight(i2);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:178:0x031e, code lost:
        if (r10 != false) goto L_0x0320;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long solverMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r27
            r4 = r29
            androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer r5 = r23.getMeasurer()
            java.util.ArrayList r6 = r1.mChildren
            int r6 = r6.size()
            int r7 = r23.getWidth()
            int r8 = r23.getHeight()
            r9 = 128(0x80, float:1.794E-43)
            boolean r9 = androidx.constraintlayout.solver.widgets.Optimizer.enabled(r2, r9)
            r10 = 0
            if (r9 != 0) goto L_0x0030
            r12 = 64
            boolean r2 = androidx.constraintlayout.solver.widgets.Optimizer.enabled(r2, r12)
            if (r2 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r2 = r10
            goto L_0x0031
        L_0x0030:
            r2 = 1
        L_0x0031:
            if (r2 == 0) goto L_0x008c
            r12 = r10
        L_0x0034:
            if (r12 >= r6) goto L_0x008c
            java.util.ArrayList r13 = r1.mChildren
            java.lang.Object r13 = r13.get(r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r13.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r15) goto L_0x0048
            r14 = 1
            goto L_0x0049
        L_0x0048:
            r14 = r10
        L_0x0049:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = r13.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r11) goto L_0x0053
            r11 = 1
            goto L_0x0054
        L_0x0053:
            r11 = r10
        L_0x0054:
            if (r14 == 0) goto L_0x0063
            if (r11 == 0) goto L_0x0063
            float r11 = r13.getDimensionRatio()
            r14 = 0
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 <= 0) goto L_0x0063
            r11 = 1
            goto L_0x0064
        L_0x0063:
            r11 = r10
        L_0x0064:
            boolean r14 = r13.isInHorizontalChain()
            if (r14 == 0) goto L_0x006e
            if (r11 == 0) goto L_0x006e
        L_0x006c:
            r2 = r10
            goto L_0x008c
        L_0x006e:
            boolean r14 = r13.isInVerticalChain()
            if (r14 == 0) goto L_0x0077
            if (r11 == 0) goto L_0x0077
            goto L_0x006c
        L_0x0077:
            boolean r11 = r13 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
            if (r11 == 0) goto L_0x007c
            goto L_0x006c
        L_0x007c:
            boolean r11 = r13.isInHorizontalChain()
            if (r11 != 0) goto L_0x006c
            boolean r11 = r13.isInVerticalChain()
            if (r11 == 0) goto L_0x0089
            goto L_0x006c
        L_0x0089:
            int r12 = r12 + 1
            goto L_0x0034
        L_0x008c:
            r11 = 1
            if (r2 == 0) goto L_0x009b
            androidx.constraintlayout.solver.Metrics r13 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r13 == 0) goto L_0x009b
            androidx.constraintlayout.solver.Metrics r13 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r14 = r13.measures
            long r14 = r14 + r11
            r13.measures = r14
        L_0x009b:
            r13 = 1073741824(0x40000000, float:2.0)
            if (r3 != r13) goto L_0x00a1
            if (r4 == r13) goto L_0x00a3
        L_0x00a1:
            if (r9 == 0) goto L_0x00a5
        L_0x00a3:
            r14 = 1
            goto L_0x00a6
        L_0x00a5:
            r14 = r10
        L_0x00a6:
            r2 = r2 & r14
            r14 = 2
            if (r2 == 0) goto L_0x0116
            int r2 = r23.getMaxWidth()
            r15 = r28
            int r2 = java.lang.Math.min(r2, r15)
            int r15 = r23.getMaxHeight()
            r11 = r30
            int r11 = java.lang.Math.min(r15, r11)
            if (r3 != r13) goto L_0x00cc
            int r12 = r23.getWidth()
            if (r12 == r2) goto L_0x00cc
            r1.setWidth(r2)
            r23.invalidateGraph()
        L_0x00cc:
            if (r4 != r13) goto L_0x00da
            int r2 = r23.getHeight()
            if (r2 == r11) goto L_0x00da
            r1.setHeight(r11)
            r23.invalidateGraph()
        L_0x00da:
            if (r3 != r13) goto L_0x00e4
            if (r4 != r13) goto L_0x00e4
            boolean r2 = r1.directMeasure(r9)
            r9 = r14
            goto L_0x0106
        L_0x00e4:
            boolean r2 = r1.directMeasureSetup(r9)
            if (r3 != r13) goto L_0x00f2
            boolean r11 = r1.directMeasureWithOrientation(r9, r10)
            r2 = r2 & r11
            r11 = r2
            r2 = 1
            goto L_0x00f4
        L_0x00f2:
            r11 = r2
            r2 = r10
        L_0x00f4:
            if (r4 != r13) goto L_0x0104
            r12 = 1
            boolean r9 = r1.directMeasureWithOrientation(r9, r12)
            r9 = r9 & r11
            int r2 = r2 + 1
            r21 = r9
            r9 = r2
            r2 = r21
            goto L_0x0106
        L_0x0104:
            r9 = r2
            r2 = r11
        L_0x0106:
            if (r2 == 0) goto L_0x0118
            if (r3 != r13) goto L_0x010c
            r3 = 1
            goto L_0x010d
        L_0x010c:
            r3 = r10
        L_0x010d:
            if (r4 != r13) goto L_0x0111
            r4 = 1
            goto L_0x0112
        L_0x0111:
            r4 = r10
        L_0x0112:
            r1.updateFromRuns(r3, r4)
            goto L_0x0118
        L_0x0116:
            r2 = r10
            r9 = r2
        L_0x0118:
            if (r2 == 0) goto L_0x011c
            if (r9 == r14) goto L_0x032a
        L_0x011c:
            if (r6 <= 0) goto L_0x0121
            r22.measureChildren(r23)
        L_0x0121:
            int r2 = r23.getOptimizationLevel()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r0.mVariableDimensionsWidgets
            int r3 = r3.size()
            if (r6 <= 0) goto L_0x0132
            java.lang.String r4 = "First pass"
            r0.solveLinearSystem(r1, r4, r7, r8)
        L_0x0132:
            if (r3 <= 0) goto L_0x0327
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r23.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r6) goto L_0x013e
            r12 = 1
            goto L_0x013f
        L_0x013e:
            r12 = r10
        L_0x013f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r23.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r6) goto L_0x0149
            r4 = 1
            goto L_0x014a
        L_0x0149:
            r4 = r10
        L_0x014a:
            int r6 = r23.getWidth()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.constraintWidgetContainer
            int r9 = r9.getMinWidth()
            int r6 = java.lang.Math.max(r6, r9)
            int r9 = r23.getHeight()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r11 = r0.constraintWidgetContainer
            int r11 = r11.getMinHeight()
            int r9 = java.lang.Math.max(r9, r11)
            r11 = r10
            r13 = r11
        L_0x0168:
            if (r11 >= r3) goto L_0x0206
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r0.mVariableDimensionsWidgets
            java.lang.Object r15 = r15.get(r11)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            boolean r10 = r15 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
            if (r10 != 0) goto L_0x017e
            r27 = r2
            r16 = r7
            r17 = r8
            goto L_0x01fa
        L_0x017e:
            int r10 = r15.getWidth()
            int r14 = r15.getHeight()
            r27 = r2
            r2 = 1
            boolean r16 = r0.measure(r5, r15, r2)
            r2 = r13 | r16
            androidx.constraintlayout.solver.Metrics r13 = r1.mMetrics
            if (r13 == 0) goto L_0x01a2
            androidx.constraintlayout.solver.Metrics r13 = r1.mMetrics
            r16 = r7
            r17 = r8
            long r7 = r13.measuredMatchWidgets
            r18 = 1
            long r7 = r7 + r18
            r13.measuredMatchWidgets = r7
            goto L_0x01a6
        L_0x01a2:
            r16 = r7
            r17 = r8
        L_0x01a6:
            int r7 = r15.getWidth()
            int r8 = r15.getHeight()
            if (r7 == r10) goto L_0x01d0
            r15.setWidth(r7)
            if (r12 == 0) goto L_0x01cf
            int r2 = r15.getRight()
            if (r2 <= r6) goto L_0x01cf
            int r2 = r15.getRight()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r15.getAnchor(r7)
            int r7 = r7.getMargin()
            int r2 = r2 + r7
            int r2 = java.lang.Math.max(r6, r2)
            r6 = r2
        L_0x01cf:
            r2 = 1
        L_0x01d0:
            if (r8 == r14) goto L_0x01f2
            r15.setHeight(r8)
            if (r4 == 0) goto L_0x01f1
            int r2 = r15.getBottom()
            if (r2 <= r9) goto L_0x01f1
            int r2 = r15.getBottom()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r15.getAnchor(r7)
            int r7 = r7.getMargin()
            int r2 = r2 + r7
            int r2 = java.lang.Math.max(r9, r2)
            r9 = r2
        L_0x01f1:
            r2 = 1
        L_0x01f2:
            androidx.constraintlayout.solver.widgets.VirtualLayout r15 = (androidx.constraintlayout.solver.widgets.VirtualLayout) r15
            boolean r7 = r15.needSolverPass()
            r13 = r2 | r7
        L_0x01fa:
            int r11 = r11 + 1
            r2 = r27
            r7 = r16
            r8 = r17
            r10 = 0
            r14 = 2
            goto L_0x0168
        L_0x0206:
            r27 = r2
            r16 = r7
            r17 = r8
            r7 = r14
            r2 = 0
        L_0x020e:
            if (r2 >= r7) goto L_0x02fd
            r8 = 0
        L_0x0211:
            if (r8 >= r3) goto L_0x02db
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r10 = r0.mVariableDimensionsWidgets
            java.lang.Object r10 = r10.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r10
            boolean r11 = r10 instanceof androidx.constraintlayout.solver.widgets.Helper
            if (r11 == 0) goto L_0x0223
            boolean r11 = r10 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
            if (r11 == 0) goto L_0x0246
        L_0x0223:
            boolean r11 = r10 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r11 == 0) goto L_0x0228
            goto L_0x0246
        L_0x0228:
            int r11 = r10.getVisibility()
            r14 = 8
            if (r11 != r14) goto L_0x0231
            goto L_0x0246
        L_0x0231:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r11 = r10.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r11.dimension
            boolean r11 = r11.resolved
            if (r11 == 0) goto L_0x0242
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r11 = r10.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r11.dimension
            boolean r11 = r11.resolved
            if (r11 == 0) goto L_0x0242
            goto L_0x0246
        L_0x0242:
            boolean r11 = r10 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
            if (r11 == 0) goto L_0x024e
        L_0x0246:
            r18 = r2
            r28 = r3
            r19 = 1
            goto L_0x02d2
        L_0x024e:
            int r11 = r10.getWidth()
            int r14 = r10.getHeight()
            int r15 = r10.getBaselineDistance()
            r7 = 1
            boolean r18 = r0.measure(r5, r10, r7)
            r13 = r13 | r18
            androidx.constraintlayout.solver.Metrics r7 = r1.mMetrics
            if (r7 == 0) goto L_0x0274
            androidx.constraintlayout.solver.Metrics r7 = r1.mMetrics
            r18 = r2
            r28 = r3
            long r2 = r7.measuredMatchWidgets
            r19 = 1
            long r2 = r2 + r19
            r7.measuredMatchWidgets = r2
            goto L_0x027a
        L_0x0274:
            r18 = r2
            r28 = r3
            r19 = 1
        L_0x027a:
            int r2 = r10.getWidth()
            int r3 = r10.getHeight()
            if (r2 == r11) goto L_0x02a3
            r10.setWidth(r2)
            if (r12 == 0) goto L_0x02a2
            int r2 = r10.getRight()
            if (r2 <= r6) goto L_0x02a2
            int r2 = r10.getRight()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r10.getAnchor(r7)
            int r7 = r7.getMargin()
            int r2 = r2 + r7
            int r6 = java.lang.Math.max(r6, r2)
        L_0x02a2:
            r13 = 1
        L_0x02a3:
            if (r3 == r14) goto L_0x02c5
            r10.setHeight(r3)
            if (r4 == 0) goto L_0x02c4
            int r2 = r10.getBottom()
            if (r2 <= r9) goto L_0x02c4
            int r2 = r10.getBottom()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r10.getAnchor(r3)
            int r3 = r3.getMargin()
            int r2 = r2 + r3
            int r2 = java.lang.Math.max(r9, r2)
            r9 = r2
        L_0x02c4:
            r13 = 1
        L_0x02c5:
            boolean r2 = r10.hasBaseline()
            if (r2 == 0) goto L_0x02d2
            int r2 = r10.getBaselineDistance()
            if (r15 == r2) goto L_0x02d2
            r13 = 1
        L_0x02d2:
            int r8 = r8 + 1
            r3 = r28
            r2 = r18
            r7 = 2
            goto L_0x0211
        L_0x02db:
            r18 = r2
            r28 = r3
            r19 = 1
            if (r13 == 0) goto L_0x02ee
            java.lang.String r2 = "intermediate pass"
            r3 = r16
            r7 = r17
            r0.solveLinearSystem(r1, r2, r3, r7)
            r13 = 0
            goto L_0x02f2
        L_0x02ee:
            r3 = r16
            r7 = r17
        L_0x02f2:
            int r2 = r18 + 1
            r16 = r3
            r17 = r7
            r7 = 2
            r3 = r28
            goto L_0x020e
        L_0x02fd:
            r3 = r16
            r7 = r17
            if (r13 == 0) goto L_0x0325
            java.lang.String r2 = "2nd pass"
            r0.solveLinearSystem(r1, r2, r3, r7)
            int r2 = r23.getWidth()
            if (r2 >= r6) goto L_0x0313
            r1.setWidth(r6)
            r10 = 1
            goto L_0x0314
        L_0x0313:
            r10 = 0
        L_0x0314:
            int r2 = r23.getHeight()
            if (r2 >= r9) goto L_0x031e
            r1.setHeight(r9)
            goto L_0x0320
        L_0x031e:
            if (r10 == 0) goto L_0x0325
        L_0x0320:
            java.lang.String r2 = "3rd pass"
            r0.solveLinearSystem(r1, r2, r3, r7)
        L_0x0325:
            r2 = r27
        L_0x0327:
            r1.setOptimizationLevel(r2)
        L_0x032a:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.solverMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, int, int, int, int, int, int, int, int, int):long");
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = z;
        boolean z2 = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }
}
