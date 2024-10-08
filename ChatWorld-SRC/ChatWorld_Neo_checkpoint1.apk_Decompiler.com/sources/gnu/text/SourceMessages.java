package gnu.text;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SourceMessages implements SourceLocator {
    public static boolean debugStackTraceOnError = false;
    public static boolean debugStackTraceOnWarning = false;
    int current_column;
    String current_filename;
    int current_line;
    private int errorCount = 0;
    SourceError firstError;
    SourceError lastError;
    SourceError lastPrevFilename = null;
    SourceLocator locator;
    public boolean sortMessages;

    public SourceError getErrors() {
        return this.firstError;
    }

    public boolean seenErrors() {
        return this.errorCount > 0;
    }

    public boolean seenErrorsOrWarnings() {
        return this.firstError != null;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public void clearErrors() {
        this.errorCount = 0;
    }

    public void clear() {
        this.lastError = null;
        this.firstError = null;
        this.errorCount = 0;
    }

    public void error(SourceError error) {
        SourceError next;
        if (error.severity == 'f') {
            this.errorCount = 1000;
        } else if (error.severity != 'w') {
            this.errorCount++;
        }
        if ((debugStackTraceOnError && (error.severity == 'e' || error.severity == 'f')) || (debugStackTraceOnWarning && error.severity == 'w')) {
            error.fakeException = new Throwable();
        }
        SourceError sourceError = this.lastError;
        if (!(sourceError == null || sourceError.filename == null || this.lastError.filename.equals(error.filename))) {
            this.lastPrevFilename = this.lastError;
        }
        SourceError prev = this.lastPrevFilename;
        if (this.sortMessages && error.severity != 'f') {
            while (true) {
                if (prev == null) {
                    next = this.firstError;
                } else {
                    next = prev.next;
                }
                if (next == null || (error.line != 0 && next.line != 0 && (error.line < next.line || (error.line == next.line && error.column != 0 && next.column != 0 && error.column < next.column)))) {
                    break;
                }
                prev = next;
            }
        } else {
            prev = this.lastError;
        }
        if (prev == null) {
            error.next = this.firstError;
            this.firstError = error;
        } else {
            error.next = prev.next;
            prev.next = error;
        }
        if (prev == this.lastError) {
            this.lastError = error;
        }
    }

    public void error(char severity, String filename, int line, int column, String message) {
        error(new SourceError(severity, filename, line, column, message));
    }

    public void error(char severity, SourceLocator location, String message) {
        error(new SourceError(severity, location, message));
    }

    public void error(char severity, String filename, int line, int column, String message, String code) {
        SourceError err = new SourceError(severity, filename, line, column, message);
        err.code = code;
        error(err);
    }

    public void error(char severity, SourceLocator location, String message, String code) {
        SourceError err = new SourceError(severity, location, message);
        err.code = code;
        error(err);
    }

    public void error(char severity, String message) {
        error(new SourceError(severity, this.current_filename, this.current_line, this.current_column, message));
    }

    public void error(char severity, String message, Throwable exception) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.fakeException = exception;
        error(err);
    }

    public void error(char severity, String message, String code) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.code = code;
        error(err);
    }

    public void printAll(PrintStream out, int max) {
        SourceError err = this.firstError;
        while (err != null) {
            max--;
            if (max >= 0) {
                err.println(out);
                err = err.next;
            } else {
                return;
            }
        }
    }

    public void printAll(PrintWriter out, int max) {
        SourceError err = this.firstError;
        while (err != null) {
            max--;
            if (max >= 0) {
                err.println(out);
                err = err.next;
            } else {
                return;
            }
        }
    }

    public String toString(int max) {
        if (this.firstError == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (SourceError err = this.firstError; err != null; err = err.next) {
            max--;
            if (max < 0) {
                break;
            }
            buffer.append(err);
            buffer.append(10);
        }
        return buffer.toString();
    }

    public boolean checkErrors(PrintWriter out, int max) {
        if (this.firstError == null) {
            return false;
        }
        printAll(out, max);
        this.lastError = null;
        this.firstError = null;
        int saveCount = this.errorCount;
        this.errorCount = 0;
        if (saveCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkErrors(PrintStream out, int max) {
        if (this.firstError == null) {
            return false;
        }
        printAll(out, max);
        this.lastError = null;
        this.firstError = null;
        int saveCount = this.errorCount;
        this.errorCount = 0;
        if (saveCount > 0) {
            return true;
        }
        return false;
    }

    public final void setSourceLocator(SourceLocator locator2) {
        this.locator = locator2 == this ? null : locator2;
    }

    public final SourceLocator swapSourceLocator(SourceLocator locator2) {
        SourceLocator save = this.locator;
        this.locator = locator2;
        return save;
    }

    public final void setLocation(SourceLocator locator2) {
        this.locator = null;
        this.current_line = locator2.getLineNumber();
        this.current_column = locator2.getColumnNumber();
        this.current_filename = locator2.getFileName();
    }

    public String getPublicId() {
        SourceLocator sourceLocator = this.locator;
        if (sourceLocator == null) {
            return null;
        }
        return sourceLocator.getPublicId();
    }

    public String getSystemId() {
        SourceLocator sourceLocator = this.locator;
        return sourceLocator == null ? this.current_filename : sourceLocator.getSystemId();
    }

    public boolean isStableSourceLocation() {
        return false;
    }

    public final String getFileName() {
        return this.current_filename;
    }

    public final int getLineNumber() {
        SourceLocator sourceLocator = this.locator;
        return sourceLocator == null ? this.current_line : sourceLocator.getLineNumber();
    }

    public final int getColumnNumber() {
        SourceLocator sourceLocator = this.locator;
        return sourceLocator == null ? this.current_column : sourceLocator.getColumnNumber();
    }

    public void setFile(String filename) {
        this.current_filename = filename;
    }

    public void setLine(int line) {
        this.current_line = line;
    }

    public void setColumn(int column) {
        this.current_column = column;
    }

    public void setLine(String filename, int line, int column) {
        this.current_filename = filename;
        this.current_line = line;
        this.current_column = column;
    }
}
