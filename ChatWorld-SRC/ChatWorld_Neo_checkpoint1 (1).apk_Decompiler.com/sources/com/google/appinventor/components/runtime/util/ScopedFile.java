package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.common.FileScope;
import com.google.appinventor.components.runtime.Form;
import java.io.File;
import java.net.URI;

public class ScopedFile {
    private final String fileName;
    private final FileScope scope;

    public ScopedFile(FileScope scope2, String fileName2) {
        if (fileName2.startsWith("//")) {
            scope2 = FileScope.Asset;
            fileName2 = fileName2.substring(2);
        } else if (!fileName2.startsWith("/") && scope2 == FileScope.Legacy) {
            scope2 = FileScope.Private;
        } else if (fileName2.startsWith("/") && scope2 != FileScope.Legacy) {
            fileName2 = fileName2.substring(1);
        }
        this.scope = scope2;
        this.fileName = fileName2;
    }

    public FileScope getScope() {
        return this.scope;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int hashCode() {
        return (this.scope.hashCode() * 37) + this.fileName.hashCode();
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof ScopedFile)) {
            return false;
        }
        ScopedFile other = (ScopedFile) obj;
        if (this.scope != other.scope) {
            return false;
        }
        String str2 = this.fileName;
        if (str2 == null && other.fileName == null) {
            return true;
        }
        if (str2 == null || (str = other.fileName) == null) {
            return false;
        }
        return str2.equals(str);
    }

    public File resolve(Form form) {
        return new File(URI.create(FileUtil.resolveFileName(form, this.fileName, this.scope)));
    }

    public String toString() {
        FileScope fileScope = this.scope;
        return "ScopedFile{scope=" + fileScope + ", fileName='" + this.fileName + "'}";
    }
}
