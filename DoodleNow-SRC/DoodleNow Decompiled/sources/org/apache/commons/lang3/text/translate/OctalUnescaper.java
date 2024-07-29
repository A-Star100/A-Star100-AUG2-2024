package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class OctalUnescaper extends CharSequenceTranslator {
    private static int OCTAL_MAX = 377;

    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (charSequence.charAt(i) != '\\' || i >= charSequence.length() - 1) {
            return 0;
        }
        int i2 = i + 1;
        if (!Character.isDigit(charSequence.charAt(i2))) {
            return 0;
        }
        int i3 = i + 2;
        while (i3 < charSequence.length() && Character.isDigit(charSequence.charAt(i3))) {
            int i4 = i3 + 1;
            if (Integer.parseInt(charSequence.subSequence(i2, i4).toString(), 10) > OCTAL_MAX) {
                break;
            }
            i3 = i4;
        }
        writer.write(Integer.parseInt(charSequence.subSequence(i2, i3).toString(), 8));
        return (i3 + 1) - i2;
    }
}
