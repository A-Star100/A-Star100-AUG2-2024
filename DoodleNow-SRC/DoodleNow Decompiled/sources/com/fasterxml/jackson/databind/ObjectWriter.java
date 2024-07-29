package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class ObjectWriter implements Versioned, Serializable {
    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    private static final long serialVersionUID = 1;
    protected final SerializationConfig _config;
    protected final JsonFactory _generatorFactory;
    protected final GeneratorSettings _generatorSettings;
    protected final Prefetch _prefetch;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    public SerializationConfig getConfig() {
        return this._config;
    }

    public JsonFactory getFactory() {
        return this._generatorFactory;
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = prettyPrinter == null ? GeneratorSettings.empty : new GeneratorSettings(prettyPrinter, (FormatSchema) null, (CharacterEscapes) null, (SerializableString) null);
        if (javaType == null || javaType.hasRawClass(Object.class)) {
            this._prefetch = Prefetch.empty;
        } else {
            this._prefetch = Prefetch.empty.forRootType(this, javaType.withStaticTyping());
        }
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = GeneratorSettings.empty;
        this._prefetch = Prefetch.empty;
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, FormatSchema formatSchema) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = formatSchema == null ? GeneratorSettings.empty : new GeneratorSettings((PrettyPrinter) null, formatSchema, (CharacterEscapes) null, (SerializableString) null);
        this._prefetch = Prefetch.empty;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig, GeneratorSettings generatorSettings, Prefetch prefetch) {
        this._config = serializationConfig;
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = objectWriter._generatorFactory;
        this._generatorSettings = generatorSettings;
        this._prefetch = prefetch;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = objectWriter._generatorFactory;
        this._generatorSettings = objectWriter._generatorSettings;
        this._prefetch = objectWriter._prefetch;
    }

    protected ObjectWriter(ObjectWriter objectWriter, JsonFactory jsonFactory) {
        this._config = objectWriter._config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, jsonFactory.requiresPropertyOrdering());
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = jsonFactory;
        this._generatorSettings = objectWriter._generatorSettings;
        this._prefetch = objectWriter._prefetch;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    /* access modifiers changed from: protected */
    public ObjectWriter _new(ObjectWriter objectWriter, JsonFactory jsonFactory) {
        return new ObjectWriter(objectWriter, jsonFactory);
    }

    /* access modifiers changed from: protected */
    public ObjectWriter _new(ObjectWriter objectWriter, SerializationConfig serializationConfig) {
        return new ObjectWriter(objectWriter, serializationConfig);
    }

    /* access modifiers changed from: protected */
    public ObjectWriter _new(GeneratorSettings generatorSettings, Prefetch prefetch) {
        return new ObjectWriter(this, this._config, generatorSettings, prefetch);
    }

    /* access modifiers changed from: protected */
    public SequenceWriter _newSequenceWriter(boolean z, JsonGenerator jsonGenerator, boolean z2) throws IOException {
        _configureGenerator(jsonGenerator);
        return new SequenceWriter(_serializerProvider(), jsonGenerator, z2, this._prefetch).init(z);
    }

    public ObjectWriter with(SerializationFeature serializationFeature) {
        SerializationConfig with = this._config.with(serializationFeature);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter with(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        SerializationConfig with = this._config.with(serializationFeature, serializationFeatureArr);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter withFeatures(SerializationFeature... serializationFeatureArr) {
        SerializationConfig withFeatures = this._config.withFeatures(serializationFeatureArr);
        if (withFeatures == this._config) {
            return this;
        }
        return _new(this, withFeatures);
    }

    public ObjectWriter without(SerializationFeature serializationFeature) {
        SerializationConfig without = this._config.without(serializationFeature);
        if (without == this._config) {
            return this;
        }
        return _new(this, without);
    }

    public ObjectWriter without(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        SerializationConfig without = this._config.without(serializationFeature, serializationFeatureArr);
        if (without == this._config) {
            return this;
        }
        return _new(this, without);
    }

    public ObjectWriter withoutFeatures(SerializationFeature... serializationFeatureArr) {
        SerializationConfig withoutFeatures = this._config.withoutFeatures(serializationFeatureArr);
        if (withoutFeatures == this._config) {
            return this;
        }
        return _new(this, withoutFeatures);
    }

    public ObjectWriter with(JsonGenerator.Feature feature) {
        SerializationConfig with = this._config.with(feature);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter withFeatures(JsonGenerator.Feature... featureArr) {
        SerializationConfig withFeatures = this._config.withFeatures(featureArr);
        if (withFeatures == this._config) {
            return this;
        }
        return _new(this, withFeatures);
    }

    public ObjectWriter without(JsonGenerator.Feature feature) {
        SerializationConfig without = this._config.without(feature);
        if (without == this._config) {
            return this;
        }
        return _new(this, without);
    }

    public ObjectWriter withoutFeatures(JsonGenerator.Feature... featureArr) {
        SerializationConfig withoutFeatures = this._config.withoutFeatures(featureArr);
        if (withoutFeatures == this._config) {
            return this;
        }
        return _new(this, withoutFeatures);
    }

    public ObjectWriter with(FormatFeature formatFeature) {
        SerializationConfig with = this._config.with(formatFeature);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter withFeatures(FormatFeature... formatFeatureArr) {
        SerializationConfig withFeatures = this._config.withFeatures(formatFeatureArr);
        if (withFeatures == this._config) {
            return this;
        }
        return _new(this, withFeatures);
    }

    public ObjectWriter without(FormatFeature formatFeature) {
        SerializationConfig without = this._config.without(formatFeature);
        if (without == this._config) {
            return this;
        }
        return _new(this, without);
    }

    public ObjectWriter withoutFeatures(FormatFeature... formatFeatureArr) {
        SerializationConfig withoutFeatures = this._config.withoutFeatures(formatFeatureArr);
        if (withoutFeatures == this._config) {
            return this;
        }
        return _new(this, withoutFeatures);
    }

    public ObjectWriter forType(JavaType javaType) {
        Prefetch forRootType = this._prefetch.forRootType(this, javaType);
        if (forRootType == this._prefetch) {
            return this;
        }
        return _new(this._generatorSettings, forRootType);
    }

    public ObjectWriter forType(Class<?> cls) {
        if (cls != Object.class) {
            return forType(this._config.constructType(cls));
        }
        JavaType javaType = null;
        return forType((JavaType) null);
    }

    public ObjectWriter forType(TypeReference<?> typeReference) {
        return forType(this._config.getTypeFactory().constructType(typeReference.getType()));
    }

    @Deprecated
    public ObjectWriter withType(JavaType javaType) {
        return forType(javaType);
    }

    @Deprecated
    public ObjectWriter withType(Class<?> cls) {
        return forType(cls);
    }

    @Deprecated
    public ObjectWriter withType(TypeReference<?> typeReference) {
        return forType(typeReference);
    }

    public ObjectWriter with(DateFormat dateFormat) {
        SerializationConfig with = this._config.with(dateFormat);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter withDefaultPrettyPrinter() {
        return with(this._config.getDefaultPrettyPrinter());
    }

    public ObjectWriter with(FilterProvider filterProvider) {
        return filterProvider == this._config.getFilterProvider() ? this : _new(this, this._config.withFilters(filterProvider));
    }

    public ObjectWriter with(PrettyPrinter prettyPrinter) {
        GeneratorSettings with = this._generatorSettings.with(prettyPrinter);
        if (with == this._generatorSettings) {
            return this;
        }
        return _new(with, this._prefetch);
    }

    public ObjectWriter withRootName(String str) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withRootName(str);
        if (serializationConfig == this._config) {
            return this;
        }
        return _new(this, serializationConfig);
    }

    public ObjectWriter withRootName(PropertyName propertyName) {
        SerializationConfig withRootName = this._config.withRootName(propertyName);
        if (withRootName == this._config) {
            return this;
        }
        return _new(this, withRootName);
    }

    public ObjectWriter withoutRootName() {
        SerializationConfig withRootName = this._config.withRootName(PropertyName.NO_NAME);
        if (withRootName == this._config) {
            return this;
        }
        return _new(this, withRootName);
    }

    public ObjectWriter with(FormatSchema formatSchema) {
        GeneratorSettings with = this._generatorSettings.with(formatSchema);
        if (with == this._generatorSettings) {
            return this;
        }
        _verifySchemaType(formatSchema);
        return _new(with, this._prefetch);
    }

    @Deprecated
    public ObjectWriter withSchema(FormatSchema formatSchema) {
        return with(formatSchema);
    }

    public ObjectWriter withView(Class<?> cls) {
        SerializationConfig withView = this._config.withView(cls);
        if (withView == this._config) {
            return this;
        }
        return _new(this, withView);
    }

    public ObjectWriter with(Locale locale) {
        SerializationConfig with = this._config.with(locale);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter with(TimeZone timeZone) {
        SerializationConfig with = this._config.with(timeZone);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter with(Base64Variant base64Variant) {
        SerializationConfig with = this._config.with(base64Variant);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter with(CharacterEscapes characterEscapes) {
        GeneratorSettings with = this._generatorSettings.with(characterEscapes);
        if (with == this._generatorSettings) {
            return this;
        }
        return _new(with, this._prefetch);
    }

    public ObjectWriter with(JsonFactory jsonFactory) {
        return jsonFactory == this._generatorFactory ? this : _new(this, jsonFactory);
    }

    public ObjectWriter with(ContextAttributes contextAttributes) {
        SerializationConfig with = this._config.with(contextAttributes);
        if (with == this._config) {
            return this;
        }
        return _new(this, with);
    }

    public ObjectWriter withAttributes(Map<?, ?> map) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withAttributes(map);
        if (serializationConfig == this._config) {
            return this;
        }
        return _new(this, serializationConfig);
    }

    public ObjectWriter withAttribute(Object obj, Object obj2) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withAttribute(obj, obj2);
        if (serializationConfig == this._config) {
            return this;
        }
        return _new(this, serializationConfig);
    }

    public ObjectWriter withoutAttribute(Object obj) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withoutAttribute(obj);
        if (serializationConfig == this._config) {
            return this;
        }
        return _new(this, serializationConfig);
    }

    public ObjectWriter withRootValueSeparator(String str) {
        GeneratorSettings withRootValueSeparator = this._generatorSettings.withRootValueSeparator(str);
        if (withRootValueSeparator == this._generatorSettings) {
            return this;
        }
        return _new(withRootValueSeparator, this._prefetch);
    }

    public ObjectWriter withRootValueSeparator(SerializableString serializableString) {
        GeneratorSettings withRootValueSeparator = this._generatorSettings.withRootValueSeparator(serializableString);
        if (withRootValueSeparator == this._generatorSettings) {
            return this;
        }
        return _new(withRootValueSeparator, this._prefetch);
    }

    public SequenceWriter writeValues(File file) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), true);
    }

    public SequenceWriter writeValues(JsonGenerator jsonGenerator) throws IOException {
        _configureGenerator(jsonGenerator);
        return _newSequenceWriter(false, jsonGenerator, false);
    }

    public SequenceWriter writeValues(Writer writer) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(writer), true);
    }

    public SequenceWriter writeValues(OutputStream outputStream) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), true);
    }

    public SequenceWriter writeValues(DataOutput dataOutput) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(dataOutput), true);
    }

    public SequenceWriter writeValuesAsArray(File file) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), true);
    }

    public SequenceWriter writeValuesAsArray(JsonGenerator jsonGenerator) throws IOException {
        return _newSequenceWriter(true, jsonGenerator, false);
    }

    public SequenceWriter writeValuesAsArray(Writer writer) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(writer), true);
    }

    public SequenceWriter writeValuesAsArray(OutputStream outputStream) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), true);
    }

    public SequenceWriter writeValuesAsArray(DataOutput dataOutput) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(dataOutput), true);
    }

    public boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    @Deprecated
    public boolean isEnabled(JsonParser.Feature feature) {
        return this._generatorFactory.isEnabled(feature);
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this._generatorFactory.isEnabled(feature);
    }

    public TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public boolean hasPrefetchedSerializer() {
        return this._prefetch.hasSerializer();
    }

    public ContextAttributes getAttributes() {
        return this._config.getAttributes();
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        _configureGenerator(jsonGenerator);
        if (!this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            if (this._config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
                return;
            }
            return;
        }
        Closeable closeable = (Closeable) obj;
        try {
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            if (this._config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
            }
            closeable.close();
        } catch (Exception e) {
            ClassUtil.closeOnFailAndThrowAsIAE((JsonGenerator) null, closeable, e);
        }
    }

    public void writeValue(File file, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(writer), obj);
    }

    public void writeValue(DataOutput dataOutput, Object obj) throws IOException {
        _configAndWriteValue(this._generatorFactory.createGenerator(dataOutput), obj);
    }

    public String writeValueAsString(Object obj) throws JsonProcessingException {
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(this._generatorFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._generatorFactory.createGenerator((Writer) segmentedStringWriter), obj);
            return segmentedStringWriter.getAndClear();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public byte[] writeValueAsBytes(Object obj) throws JsonProcessingException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(this._generatorFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._generatorFactory.createGenerator((OutputStream) byteArrayBuilder, JsonEncoding.UTF8), obj);
            byte[] byteArray = byteArrayBuilder.toByteArray();
            byteArrayBuilder.release();
            return byteArray;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public void acceptJsonFormatVisitor(JavaType javaType, JsonFormatVisitorWrapper jsonFormatVisitorWrapper) throws JsonMappingException {
        if (javaType != null) {
            _serializerProvider().acceptJsonFormatVisitor(javaType, jsonFormatVisitorWrapper);
            return;
        }
        throw new IllegalArgumentException("type must be provided");
    }

    public void acceptJsonFormatVisitor(Class<?> cls, JsonFormatVisitorWrapper jsonFormatVisitorWrapper) throws JsonMappingException {
        acceptJsonFormatVisitor(this._config.constructType(cls), jsonFormatVisitorWrapper);
    }

    public boolean canSerialize(Class<?> cls) {
        return _serializerProvider().hasSerializerFor(cls, (AtomicReference<Throwable>) null);
    }

    public boolean canSerialize(Class<?> cls, AtomicReference<Throwable> atomicReference) {
        return _serializerProvider().hasSerializerFor(cls, atomicReference);
    }

    /* access modifiers changed from: protected */
    public DefaultSerializerProvider _serializerProvider() {
        return this._serializerProvider.createInstance(this._config, this._serializerFactory);
    }

    /* access modifiers changed from: protected */
    public void _verifySchemaType(FormatSchema formatSchema) {
        if (formatSchema != null && !this._generatorFactory.canUseSchema(formatSchema)) {
            throw new IllegalArgumentException("Can not use FormatSchema of type " + formatSchema.getClass().getName() + " for format " + this._generatorFactory.getFormatName());
        }
    }

    /* access modifiers changed from: protected */
    public final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        _configureGenerator(jsonGenerator);
        if (!this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
                jsonGenerator.close();
            } catch (Exception e) {
                ClassUtil.closeOnFailAndThrowAsIAE(jsonGenerator, e);
            }
        } else {
            _writeCloseable(jsonGenerator, obj);
        }
    }

    private final void _writeCloseable(JsonGenerator jsonGenerator, Object obj) throws IOException {
        Closeable closeable = (Closeable) obj;
        try {
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            try {
                closeable.close();
                jsonGenerator.close();
            } catch (Exception e) {
                e = e;
                closeable = null;
                ClassUtil.closeOnFailAndThrowAsIAE(jsonGenerator, closeable, e);
            }
        } catch (Exception e2) {
            e = e2;
            ClassUtil.closeOnFailAndThrowAsIAE(jsonGenerator, closeable, e);
        }
    }

    /* access modifiers changed from: protected */
    public final void _configureGenerator(JsonGenerator jsonGenerator) {
        this._config.initialize(jsonGenerator);
        this._generatorSettings.initialize(jsonGenerator);
    }

    public static final class GeneratorSettings implements Serializable {
        public static final GeneratorSettings empty = new GeneratorSettings((PrettyPrinter) null, (FormatSchema) null, (CharacterEscapes) null, (SerializableString) null);
        private static final long serialVersionUID = 1;
        public final CharacterEscapes characterEscapes;
        public final PrettyPrinter prettyPrinter;
        public final SerializableString rootValueSeparator;
        public final FormatSchema schema;

        public GeneratorSettings(PrettyPrinter prettyPrinter2, FormatSchema formatSchema, CharacterEscapes characterEscapes2, SerializableString serializableString) {
            this.prettyPrinter = prettyPrinter2;
            this.schema = formatSchema;
            this.characterEscapes = characterEscapes2;
            this.rootValueSeparator = serializableString;
        }

        public GeneratorSettings with(PrettyPrinter prettyPrinter2) {
            if (prettyPrinter2 == null) {
                prettyPrinter2 = ObjectWriter.NULL_PRETTY_PRINTER;
            }
            if (prettyPrinter2 == this.prettyPrinter) {
                return this;
            }
            return new GeneratorSettings(prettyPrinter2, this.schema, this.characterEscapes, this.rootValueSeparator);
        }

        public GeneratorSettings with(FormatSchema formatSchema) {
            return this.schema == formatSchema ? this : new GeneratorSettings(this.prettyPrinter, formatSchema, this.characterEscapes, this.rootValueSeparator);
        }

        public GeneratorSettings with(CharacterEscapes characterEscapes2) {
            return this.characterEscapes == characterEscapes2 ? this : new GeneratorSettings(this.prettyPrinter, this.schema, characterEscapes2, this.rootValueSeparator);
        }

        public GeneratorSettings withRootValueSeparator(String str) {
            if (str == null) {
                if (this.rootValueSeparator == null) {
                    return this;
                }
            } else if (str.equals(this.rootValueSeparator)) {
                return this;
            }
            return new GeneratorSettings(this.prettyPrinter, this.schema, this.characterEscapes, str == null ? null : new SerializedString(str));
        }

        public GeneratorSettings withRootValueSeparator(SerializableString serializableString) {
            if (serializableString == null) {
                if (this.rootValueSeparator == null) {
                    return this;
                }
            } else if (this.rootValueSeparator != null && serializableString.getValue().equals(this.rootValueSeparator.getValue())) {
                return this;
            }
            return new GeneratorSettings(this.prettyPrinter, this.schema, this.characterEscapes, serializableString);
        }

        public void initialize(JsonGenerator jsonGenerator) {
            PrettyPrinter prettyPrinter2 = this.prettyPrinter;
            if (prettyPrinter2 != null) {
                if (prettyPrinter2 == ObjectWriter.NULL_PRETTY_PRINTER) {
                    jsonGenerator.setPrettyPrinter((PrettyPrinter) null);
                } else {
                    if (prettyPrinter2 instanceof Instantiatable) {
                        prettyPrinter2 = (PrettyPrinter) ((Instantiatable) prettyPrinter2).createInstance();
                    }
                    jsonGenerator.setPrettyPrinter(prettyPrinter2);
                }
            }
            CharacterEscapes characterEscapes2 = this.characterEscapes;
            if (characterEscapes2 != null) {
                jsonGenerator.setCharacterEscapes(characterEscapes2);
            }
            FormatSchema formatSchema = this.schema;
            if (formatSchema != null) {
                jsonGenerator.setSchema(formatSchema);
            }
            SerializableString serializableString = this.rootValueSeparator;
            if (serializableString != null) {
                jsonGenerator.setRootValueSeparator(serializableString);
            }
        }
    }

    public static final class Prefetch implements Serializable {
        public static final Prefetch empty = new Prefetch((JavaType) null, (JsonSerializer<Object>) null, (TypeSerializer) null);
        private static final long serialVersionUID = 1;
        private final JavaType rootType;
        private final TypeSerializer typeSerializer;
        private final JsonSerializer<Object> valueSerializer;

        public final TypeSerializer getTypeSerializer() {
            return this.typeSerializer;
        }

        public final JsonSerializer<Object> getValueSerializer() {
            return this.valueSerializer;
        }

        public boolean hasSerializer() {
            return (this.valueSerializer == null && this.typeSerializer == null) ? false : true;
        }

        private Prefetch(JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer2) {
            this.rootType = javaType;
            this.valueSerializer = jsonSerializer;
            this.typeSerializer = typeSerializer2;
        }

        public Prefetch forRootType(ObjectWriter objectWriter, JavaType javaType) {
            if (javaType == null || javaType.isJavaLangObject()) {
                return (this.rootType == null || this.valueSerializer == null) ? this : new Prefetch((JavaType) null, (JsonSerializer<Object>) null, this.typeSerializer);
            }
            if (javaType.equals(this.rootType)) {
                return this;
            }
            if (objectWriter.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH)) {
                try {
                    JsonSerializer<Object> findTypedValueSerializer = objectWriter._serializerProvider().findTypedValueSerializer(javaType, true, (BeanProperty) null);
                    if (findTypedValueSerializer instanceof TypeWrappedSerializer) {
                        return new Prefetch(javaType, (JsonSerializer<Object>) null, ((TypeWrappedSerializer) findTypedValueSerializer).typeSerializer());
                    }
                    return new Prefetch(javaType, findTypedValueSerializer, (TypeSerializer) null);
                } catch (JsonProcessingException unused) {
                }
            }
            return new Prefetch(javaType, (JsonSerializer<Object>) null, this.typeSerializer);
        }

        public void serialize(JsonGenerator jsonGenerator, Object obj, DefaultSerializerProvider defaultSerializerProvider) throws IOException {
            TypeSerializer typeSerializer2 = this.typeSerializer;
            if (typeSerializer2 != null) {
                defaultSerializerProvider.serializePolymorphic(jsonGenerator, obj, this.rootType, this.valueSerializer, typeSerializer2);
                return;
            }
            JsonSerializer<Object> jsonSerializer = this.valueSerializer;
            if (jsonSerializer != null) {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj, this.rootType, jsonSerializer);
                return;
            }
            JavaType javaType = this.rootType;
            if (javaType != null) {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj, javaType);
            } else {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj);
            }
        }
    }
}
