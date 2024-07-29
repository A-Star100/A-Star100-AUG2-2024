package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Constructor proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public ProtoBuf.Constructor getProto() {
        return this.proto;
    }

    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isSuspend() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeserializedClassConstructorDescriptor(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, constructorDescriptor, annotations, z, kind, constructor, nameResolver2, typeTable2, versionRequirementTable2, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassConstructorDescriptor(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, z, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        ProtoBuf.Constructor constructor2 = constructor;
        NameResolver nameResolver3 = nameResolver2;
        TypeTable typeTable3 = typeTable2;
        VersionRequirementTable versionRequirementTable3 = versionRequirementTable2;
        ClassDescriptor classDescriptor2 = classDescriptor;
        Intrinsics.checkNotNullParameter(classDescriptor, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(constructor2, "proto");
        Intrinsics.checkNotNullParameter(nameResolver3, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable3, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable3, "versionRequirementTable");
        this.proto = constructor2;
        this.nameResolver = nameResolver3;
        this.typeTable = typeTable3;
        this.versionRequirementTable = versionRequirementTable3;
        this.containerSource = deserializedContainerSource;
    }

    /* access modifiers changed from: protected */
    public DeserializedClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        CallableMemberDescriptor.Kind kind2 = kind;
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Annotations annotations2 = annotations;
        Intrinsics.checkNotNullParameter(annotations2, "annotations");
        SourceElement sourceElement2 = sourceElement;
        Intrinsics.checkNotNullParameter(sourceElement2, "source");
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor((ClassDescriptor) declarationDescriptor, (ConstructorDescriptor) functionDescriptor, annotations2, this.isPrimary, kind2, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement2);
        deserializedClassConstructorDescriptor.setHasStableParameterNames(hasStableParameterNames());
        return deserializedClassConstructorDescriptor;
    }
}
