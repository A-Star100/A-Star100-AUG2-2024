package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX WARNING: type inference failed for: r4v11, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03db  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x03c4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r35, androidx.constraintlayout.solver.LinearSystem r36, int r37, int r38, androidx.constraintlayout.solver.widgets.ChainHead r39) {
        /*
            r0 = r35
            r9 = r36
            r1 = r39
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 1
            if (r4 != r5) goto L_0x0021
            r4 = r6
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r37 != 0) goto L_0x0038
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x002b
            r8 = r6
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.mHorizontalChainStyle
            if (r14 != r6) goto L_0x0032
            r14 = r6
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.mHorizontalChainStyle
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.mVerticalChainStyle
            if (r8 != 0) goto L_0x003e
            r8 = r6
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.mVerticalChainStyle
            if (r14 != r6) goto L_0x0045
            r14 = r6
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.mVerticalChainStyle
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = r6
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r6 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x0051:
            r21 = 0
            if (r8 != 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r38]
            if (r5 == 0) goto L_0x005e
            r19 = 1
            goto L_0x0060
        L_0x005e:
            r19 = 4
        L_0x0060:
            int r22 = r7.getMargin()
            r23 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r6.mListDimensionBehaviors
            r3 = r3[r37]
            r24 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x0078
            int[] r3 = r6.mResolvedMatchConstraintDefault
            r3 = r3[r37]
            if (r3 != 0) goto L_0x0078
            r3 = 1
            goto L_0x0079
        L_0x0078:
            r3 = 0
        L_0x0079:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mTarget
            if (r8 == 0) goto L_0x0087
            if (r6 == r10) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mTarget
            int r8 = r8.getMargin()
            int r22 = r22 + r8
        L_0x0087:
            r8 = r22
            if (r5 == 0) goto L_0x0094
            if (r6 == r10) goto L_0x0094
            if (r6 == r12) goto L_0x0094
            r22 = r15
            r19 = 5
            goto L_0x0096
        L_0x0094:
            r22 = r15
        L_0x0096:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.mTarget
            if (r15 == 0) goto L_0x00cc
            if (r6 != r12) goto L_0x00ab
            androidx.constraintlayout.solver.SolverVariable r15 = r7.mSolverVariable
            r25 = r14
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r26 = r2
            r2 = 6
            r9.addGreaterThan(r15, r14, r8, r2)
            goto L_0x00ba
        L_0x00ab:
            r26 = r2
            r25 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r15 = 8
            r9.addGreaterThan(r2, r14, r8, r15)
        L_0x00ba:
            if (r3 == 0) goto L_0x00c0
            if (r5 != 0) goto L_0x00c0
            r2 = 5
            goto L_0x00c2
        L_0x00c0:
            r2 = r19
        L_0x00c2:
            androidx.constraintlayout.solver.SolverVariable r3 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r9.addEquality(r3, r7, r8, r2)
            goto L_0x00d0
        L_0x00cc:
            r26 = r2
            r25 = r14
        L_0x00d0:
            if (r4 == 0) goto L_0x0108
            int r2 = r6.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r6.mListDimensionBehaviors
            r2 = r2[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 5
            r8 = 0
            r9.addGreaterThan(r2, r3, r8, r7)
            goto L_0x00f7
        L_0x00f6:
            r8 = 0
        L_0x00f7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 8
            r9.addGreaterThan(r2, r3, r8, r7)
        L_0x0108:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0129
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0129
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r6) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r21 = r2
        L_0x0129:
            if (r21 == 0) goto L_0x0130
            r6 = r21
            r8 = r24
            goto L_0x0131
        L_0x0130:
            r8 = 1
        L_0x0131:
            r15 = r22
            r3 = r23
            r14 = r25
            r2 = r26
            goto L_0x0051
        L_0x013b:
            r26 = r2
            r23 = r3
            r25 = r14
            r22 = r15
            if (r13 == 0) goto L_0x01a5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x01a5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0179
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r37]
            if (r6 != 0) goto L_0x0179
            if (r5 != 0) goto L_0x0179
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x0179
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r14 = 5
            r9.addEquality(r6, r7, r8, r14)
            goto L_0x0191
        L_0x0179:
            r14 = 5
            if (r5 == 0) goto L_0x0191
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x0191
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r15 = 4
            r9.addEquality(r6, r7, r8, r15)
        L_0x0191:
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r7 = 6
            r9.addLowerThan(r6, r3, r2, r7)
            goto L_0x01a6
        L_0x01a5:
            r14 = 5
        L_0x01a6:
            if (r4 == 0) goto L_0x01c3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r38 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r2 = r4[r2]
            int r2 = r2.getMargin()
            r4 = 8
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x01c3:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x027a
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x027a
            boolean r4 = r1.mHasUndefinedWeights
            if (r4 == 0) goto L_0x01da
            boolean r4 = r1.mHasComplexMatchWeights
            if (r4 != 0) goto L_0x01da
            int r4 = r1.mWidgetsMatchCount
            float r4 = (float) r4
            goto L_0x01dc
        L_0x01da:
            r4 = r23
        L_0x01dc:
            r6 = 0
            r28 = r6
            r7 = r21
            r8 = 0
        L_0x01e2:
            if (r8 >= r2) goto L_0x027a
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r3 = r15.mWeight
            r3 = r3[r37]
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 >= 0) goto L_0x0210
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 == 0) goto L_0x020b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r18 = r38 + 1
            r3 = r3[r18]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.mListAnchors
            r15 = r15[r38]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r6 = 0
            r14 = 4
            r9.addEquality(r3, r15, r6, r14)
            r14 = r6
            goto L_0x0229
        L_0x020b:
            r14 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            goto L_0x0211
        L_0x0210:
            r14 = 4
        L_0x0211:
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 != 0) goto L_0x022e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r18 = r38 + 1
            r3 = r3[r18]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.mListAnchors
            r15 = r15[r38]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r6 = 8
            r14 = 0
            r9.addEquality(r3, r15, r14, r6)
        L_0x0229:
            r23 = r0
            r17 = r2
            goto L_0x026f
        L_0x022e:
            r14 = 0
            if (r7 == 0) goto L_0x0268
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r38]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r7.mListAnchors
            int r17 = r38 + 1
            r7 = r7[r17]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r15.mListAnchors
            r14 = r14[r38]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r23 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r15.mListAnchors
            r0 = r0[r17]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r17 = r2
            androidx.constraintlayout.solver.ArrayRow r2 = r36.createRow()
            r27 = r2
            r29 = r4
            r30 = r3
            r31 = r6
            r32 = r7
            r33 = r14
            r34 = r0
            r27.createRowEqualMatchDimensions(r28, r29, r30, r31, r32, r33, r34)
            r9.addConstraint(r2)
            goto L_0x026c
        L_0x0268:
            r23 = r0
            r17 = r2
        L_0x026c:
            r28 = r3
            r7 = r15
        L_0x026f:
            int r8 = r8 + 1
            r2 = r17
            r0 = r23
            r3 = 1
            r6 = 0
            r14 = 5
            goto L_0x01e2
        L_0x027a:
            if (r12 == 0) goto L_0x02d3
            if (r12 == r13) goto L_0x0280
            if (r5 == 0) goto L_0x02d3
        L_0x0280:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0294
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r3 = r0
            goto L_0x0296
        L_0x0294:
            r3 = r21
        L_0x0296:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.mTarget
            if (r0 == 0) goto L_0x02a0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r5 = r0
            goto L_0x02a2
        L_0x02a0:
            r5 = r21
        L_0x02a2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
            if (r3 == 0) goto L_0x04f5
            if (r5 == 0) goto L_0x04f5
            if (r37 != 0) goto L_0x02b5
            r2 = r26
            float r2 = r2.mHorizontalBiasPercent
            goto L_0x02b9
        L_0x02b5:
            r2 = r26
            float r2 = r2.mVerticalBiasPercent
        L_0x02b9:
            r4 = r2
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 7
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04f5
        L_0x02d3:
            if (r25 == 0) goto L_0x03c8
            if (r12 == 0) goto L_0x03c8
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02e4
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x02e4
            r16 = 1
            goto L_0x02e6
        L_0x02e4:
            r16 = 0
        L_0x02e6:
            r14 = r12
            r15 = r14
        L_0x02e8:
            if (r14 == 0) goto L_0x04f5
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r37]
            r8 = r0
        L_0x02ef:
            if (r8 == 0) goto L_0x02fe
            int r0 = r8.getVisibility()
            r7 = 8
            if (r0 != r7) goto L_0x0300
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r37]
            goto L_0x02ef
        L_0x02fe:
            r7 = 8
        L_0x0300:
            if (r8 != 0) goto L_0x030b
            if (r14 != r13) goto L_0x0305
            goto L_0x030b
        L_0x0305:
            r17 = r8
            r19 = 5
            goto L_0x03bb
        L_0x030b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x031a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x031c
        L_0x031a:
            r2 = r21
        L_0x031c:
            if (r15 == r14) goto L_0x0327
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x033e
        L_0x0327:
            if (r14 != r12) goto L_0x033e
            if (r15 != r14) goto L_0x033e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x033c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x033e
        L_0x033c:
            r2 = r21
        L_0x033e:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r38 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x035b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            goto L_0x036e
        L_0x035b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0366
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0368
        L_0x0366:
            r6 = r21
        L_0x0368:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x036e:
            if (r5 == 0) goto L_0x0375
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x0375:
            if (r15 == 0) goto L_0x0380
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x0380:
            if (r1 == 0) goto L_0x0305
            if (r2 == 0) goto L_0x0305
            if (r6 == 0) goto L_0x0305
            if (r7 == 0) goto L_0x0305
            if (r14 != r12) goto L_0x0392
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r38]
            int r0 = r0.getMargin()
        L_0x0392:
            r5 = r0
            if (r14 != r13) goto L_0x03a0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x03a2
        L_0x03a0:
            r17 = r3
        L_0x03a2:
            if (r16 == 0) goto L_0x03a7
            r18 = 8
            goto L_0x03a9
        L_0x03a7:
            r18 = 5
        L_0x03a9:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r3 = r5
            r5 = r6
            r6 = r7
            r19 = 5
            r7 = r17
            r17 = r8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x03bb:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x03c4
            r15 = r14
        L_0x03c4:
            r14 = r17
            goto L_0x02e8
        L_0x03c8:
            r8 = 8
            if (r22 == 0) goto L_0x04f5
            if (r12 == 0) goto L_0x04f5
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03db
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x03db
            r16 = 1
            goto L_0x03dd
        L_0x03db:
            r16 = 0
        L_0x03dd:
            r14 = r12
            r15 = r14
        L_0x03df:
            if (r14 == 0) goto L_0x049d
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r37]
        L_0x03e5:
            if (r0 == 0) goto L_0x03f2
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x03f2
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r37]
            goto L_0x03e5
        L_0x03f2:
            if (r14 == r12) goto L_0x048a
            if (r14 == r13) goto L_0x048a
            if (r0 == 0) goto L_0x048a
            if (r0 != r13) goto L_0x03fd
            r7 = r21
            goto L_0x03fe
        L_0x03fd:
            r7 = r0
        L_0x03fe:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x040c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x040c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0434
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x0431
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            goto L_0x0445
        L_0x0431:
            r8 = r21
            goto L_0x0445
        L_0x0434:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r5 = r5[r38]
            if (r5 == 0) goto L_0x043d
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x043f
        L_0x043d:
            r6 = r21
        L_0x043f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x0445:
            if (r5 == 0) goto L_0x044c
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x044c:
            r17 = r4
            if (r15 == 0) goto L_0x0459
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x0459:
            r3 = r0
            if (r16 == 0) goto L_0x045f
            r18 = 8
            goto L_0x0461
        L_0x045f:
            r18 = 4
        L_0x0461:
            if (r1 == 0) goto L_0x047f
            if (r2 == 0) goto L_0x047f
            if (r6 == 0) goto L_0x047f
            if (r8 == 0) goto L_0x047f
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r5 = r6
            r6 = r8
            r19 = r7
            r20 = 4
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0487
        L_0x047f:
            r19 = r7
            r17 = r15
            r15 = 8
            r20 = 4
        L_0x0487:
            r0 = r19
            goto L_0x048f
        L_0x048a:
            r17 = r15
            r20 = 4
            r15 = r8
        L_0x048f:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x0496
            goto L_0x0498
        L_0x0496:
            r14 = r17
        L_0x0498:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x03df
        L_0x049d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r38 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            r15 = 5
            if (r1 == 0) goto L_0x04e5
            if (r12 == r13) goto L_0x04c4
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x04e5
        L_0x04c4:
            if (r14 == 0) goto L_0x04e5
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r14.mSolverVariable
            int r8 = r10.getMargin()
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r15
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04e5:
            if (r14 == 0) goto L_0x04f5
            if (r12 == r13) goto L_0x04f5
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x04f5:
            if (r25 != 0) goto L_0x04f9
            if (r22 == 0) goto L_0x0560
        L_0x04f9:
            if (r12 == 0) goto L_0x0560
            if (r12 == r13) goto L_0x0560
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0510
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0512
        L_0x0510:
            r3 = r21
        L_0x0512:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x051b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x051d
        L_0x051b:
            r4 = r21
        L_0x051d:
            if (r11 == r13) goto L_0x0530
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x052d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r21 = r4
        L_0x052d:
            r5 = r21
            goto L_0x0531
        L_0x0530:
            r5 = r4
        L_0x0531:
            if (r12 != r13) goto L_0x053b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x053b:
            if (r3 == 0) goto L_0x0560
            if (r5 == 0) goto L_0x0560
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            if (r13 != 0) goto L_0x0548
            goto L_0x0549
        L_0x0548:
            r11 = r13
        L_0x0549:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0560:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
