package org.apache.commons.lang3.text;

import java.text.Format;
import java.util.Locale;

public interface FormatFactory {
    Format getFormat(String str, String str2, Locale locale);
}
