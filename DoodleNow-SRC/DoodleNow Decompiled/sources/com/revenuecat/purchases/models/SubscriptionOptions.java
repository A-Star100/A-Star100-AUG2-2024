package com.revenuecat.purchases.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0003J\u0017\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0001J\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002J\u0011\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000fH\u0003J\b\u0010$\u001a\u00020\u000fH\u0016J\u0011\u0010%\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0001J\t\u0010&\u001a\u00020\u0017H\u0001J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0003J\u0011\u0010)\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0001J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0001J\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010#\u001a\u00020\u000fH\u0001J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0001J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00100\u001a\u000201R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOptions;", "", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "subscriptionOptions", "(Ljava/util/List;)V", "basePlan", "getBasePlan", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "defaultOffer", "getDefaultOffer", "freeTrial", "getFreeTrial", "introOffer", "getIntroOffer", "size", "", "getSize", "()I", "billingPeriodToDays", "period", "Lcom/revenuecat/purchases/models/Period;", "billingPeriodToDays$purchases_defaultsRelease", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "findLongestFreeTrial", "offers", "findLowestNonFreeOffer", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "withTag", "tag", "", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionOptions.kt */
public final class SubscriptionOptions implements List<SubscriptionOption>, KMappedMarker {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String RC_IGNORE_OFFER_TAG = "rc-ignore-offer";
    private final List<SubscriptionOption> subscriptionOptions;

    public void add(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "element");
        return this.subscriptionOptions.contains(subscriptionOption);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.subscriptionOptions.containsAll(collection);
    }

    public SubscriptionOption get(int i) {
        return this.subscriptionOptions.get(i);
    }

    public int getSize() {
        return this.subscriptionOptions.size();
    }

    public int indexOf(SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "element");
        return this.subscriptionOptions.indexOf(subscriptionOption);
    }

    public boolean isEmpty() {
        return this.subscriptionOptions.isEmpty();
    }

    public Iterator<SubscriptionOption> iterator() {
        return this.subscriptionOptions.iterator();
    }

    public int lastIndexOf(SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "element");
        return this.subscriptionOptions.lastIndexOf(subscriptionOption);
    }

    public ListIterator<SubscriptionOption> listIterator() {
        return this.subscriptionOptions.listIterator();
    }

    public ListIterator<SubscriptionOption> listIterator(int i) {
        return this.subscriptionOptions.listIterator(i);
    }

    public SubscriptionOption remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<SubscriptionOption> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SubscriptionOption set(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void sort(Comparator<? super SubscriptionOption> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<SubscriptionOption> subList(int i, int i2) {
        return this.subscriptionOptions.subList(i, i2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public SubscriptionOptions(List<? extends SubscriptionOption> list) {
        Intrinsics.checkNotNullParameter(list, "subscriptionOptions");
        this.subscriptionOptions = list;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof SubscriptionOption)) {
            return false;
        }
        return contains((SubscriptionOption) obj);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof SubscriptionOption)) {
            return -1;
        }
        return indexOf((SubscriptionOption) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof SubscriptionOption)) {
            return -1;
        }
        return lastIndexOf((SubscriptionOption) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOptions$Companion;", "", "()V", "RC_IGNORE_OFFER_TAG", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriptionOptions.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SubscriptionOption getBasePlan() {
        Object obj;
        Iterator it = iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SubscriptionOption) obj).isBasePlan()) {
                break;
            }
        }
        return (SubscriptionOption) obj;
    }

    public final SubscriptionOption getFreeTrial() {
        Object obj;
        Iterator it = iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SubscriptionOption) obj).getFreePhase() != null) {
                break;
            }
        }
        return (SubscriptionOption) obj;
    }

    public final SubscriptionOption getIntroOffer() {
        Object obj;
        Iterator it = iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SubscriptionOption) obj).getIntroPhase() != null) {
                break;
            }
        }
        return (SubscriptionOption) obj;
    }

    public final SubscriptionOption getDefaultOffer() {
        Object obj;
        Iterable iterable = this;
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SubscriptionOption) obj).isBasePlan()) {
                break;
            }
        }
        SubscriptionOption subscriptionOption = (SubscriptionOption) obj;
        if (subscriptionOption == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!((SubscriptionOption) next).isBasePlan()) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (!((SubscriptionOption) next2).getTags().contains(RC_IGNORE_OFFER_TAG)) {
                arrayList2.add(next2);
            }
        }
        List list = (List) arrayList2;
        SubscriptionOption findLongestFreeTrial = findLongestFreeTrial(list);
        if (findLongestFreeTrial != null) {
            return findLongestFreeTrial;
        }
        SubscriptionOption findLowestNonFreeOffer = findLowestNonFreeOffer(list);
        return findLowestNonFreeOffer == null ? subscriptionOption : findLowestNonFreeOffer;
    }

    public final List<SubscriptionOption> withTag(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Collection arrayList = new ArrayList();
        for (Object next : this) {
            if (((SubscriptionOption) next).getTags().contains(str)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final SubscriptionOption findLongestFreeTrial(List<? extends SubscriptionOption> list) {
        Object obj;
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase freePhase = subscriptionOption.getFreePhase();
            if (freePhase != null) {
                pair = new Pair(subscriptionOption, Integer.valueOf(billingPeriodToDays$purchases_defaultsRelease(freePhase.getBillingPeriod())));
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = ((List) arrayList).iterator();
        if (!it2.hasNext()) {
            obj = null;
        } else {
            obj = it2.next();
            if (it2.hasNext()) {
                int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                do {
                    Object next = it2.next();
                    int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                    if (intValue < intValue2) {
                        obj = next;
                        intValue = intValue2;
                    }
                } while (it2.hasNext());
            }
        }
        Pair pair2 = (Pair) obj;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.getFirst();
        }
        return null;
    }

    private final SubscriptionOption findLowestNonFreeOffer(List<? extends SubscriptionOption> list) {
        Object obj;
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase introPhase = subscriptionOption.getIntroPhase();
            if (introPhase != null) {
                pair = new Pair(subscriptionOption, Long.valueOf(introPhase.getPrice().getAmountMicros()));
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = ((List) arrayList).iterator();
        if (!it2.hasNext()) {
            obj = null;
        } else {
            obj = it2.next();
            if (it2.hasNext()) {
                long longValue = ((Number) ((Pair) obj).getSecond()).longValue();
                do {
                    Object next = it2.next();
                    long longValue2 = ((Number) ((Pair) next).getSecond()).longValue();
                    if (longValue > longValue2) {
                        obj = next;
                        longValue = longValue2;
                    }
                } while (it2.hasNext());
            }
        }
        Pair pair2 = (Pair) obj;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.getFirst();
        }
        return null;
    }

    public final int billingPeriodToDays$purchases_defaultsRelease(Period period) {
        Intrinsics.checkNotNullParameter(period, "period");
        Integer num = (Integer) SubscriptionOptionsKt.DAYS_IN_UNIT.get(period.getUnit());
        return period.getValue() * (num != null ? num.intValue() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        SubscriptionOptions subscriptionOptions2 = null;
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj instanceof SubscriptionOptions) {
            subscriptionOptions2 = (SubscriptionOptions) obj;
        }
        if (subscriptionOptions2 != null) {
            return Intrinsics.areEqual((Object) CollectionsKt.listOf(this.subscriptionOptions), (Object) CollectionsKt.listOf(((SubscriptionOptions) obj).subscriptionOptions));
        }
        SubscriptionOptions subscriptionOptions3 = this;
        return false;
    }

    public int hashCode() {
        return CollectionsKt.listOf(this.subscriptionOptions).hashCode();
    }
}
