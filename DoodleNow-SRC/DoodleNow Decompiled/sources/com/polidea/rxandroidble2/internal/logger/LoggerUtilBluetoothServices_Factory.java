package com.polidea.rxandroidble2.internal.logger;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;

public final class LoggerUtilBluetoothServices_Factory implements Factory<LoggerUtilBluetoothServices> {
    private final Provider<CharacteristicPropertiesParser> characteristicPropertiesParserProvider;

    public LoggerUtilBluetoothServices_Factory(Provider<CharacteristicPropertiesParser> provider) {
        this.characteristicPropertiesParserProvider = provider;
    }

    public LoggerUtilBluetoothServices get() {
        return newInstance(this.characteristicPropertiesParserProvider.get());
    }

    public static LoggerUtilBluetoothServices_Factory create(Provider<CharacteristicPropertiesParser> provider) {
        return new LoggerUtilBluetoothServices_Factory(provider);
    }

    public static LoggerUtilBluetoothServices newInstance(CharacteristicPropertiesParser characteristicPropertiesParser) {
        return new LoggerUtilBluetoothServices(characteristicPropertiesParser);
    }
}
