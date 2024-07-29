package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFYS_TABLE = "CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFY_INTERCEPTOR_TABLE = "CREATE TABLE IF NOT EXISTS identify_interceptor (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_LONG_STORE_TABLE = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
    private static final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);";
    private static final String EVENT_FIELD = "event";
    protected static final String EVENT_TABLE_NAME = "events";
    protected static final String IDENTIFY_INTERCEPTOR_TABLE_NAME = "identify_interceptor";
    protected static final String IDENTIFY_TABLE_NAME = "identifys";
    private static final String ID_FIELD = "id";
    private static final String KEY_FIELD = "key";
    protected static final String LONG_STORE_TABLE_NAME = "long_store";
    protected static final String STORE_TABLE_NAME = "store";
    private static final String TAG = "com.amplitude.api.DatabaseHelper";
    private static final String VALUE_FIELD = "value";
    static final Map<String, DatabaseHelper> instances = new HashMap();
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    private boolean callResetListenerOnDatabaseReset;
    private DatabaseResetListener databaseResetListener;
    File file;
    private String instanceName;

    /* access modifiers changed from: package-private */
    public void setDatabaseResetListener(DatabaseResetListener databaseResetListener2) {
        this.databaseResetListener = databaseResetListener2;
    }

    @Deprecated
    static DatabaseHelper getDatabaseHelper(Context context) {
        return getDatabaseHelper(context, (String) null);
    }

    static synchronized DatabaseHelper getDatabaseHelper(Context context, String str) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            String normalizeInstanceName = Utils.normalizeInstanceName(str);
            Map<String, DatabaseHelper> map = instances;
            databaseHelper = map.get(normalizeInstanceName);
            if (databaseHelper == null) {
                databaseHelper = new DatabaseHelper(context.getApplicationContext(), normalizeInstanceName);
                map.put(normalizeInstanceName, databaseHelper);
            }
        }
        return databaseHelper;
    }

    private static String getDatabaseName(String str) {
        if (Utils.isEmptyString(str) || str.equals(Constants.DEFAULT_INSTANCE)) {
            return "com.amplitude.api";
        }
        return "com.amplitude.api_" + str;
    }

    protected DatabaseHelper(Context context) {
        this(context, (String) null);
    }

    protected DatabaseHelper(Context context, String str) {
        super(context, getDatabaseName(str), (SQLiteDatabase.CursorFactory) null, 4);
        this.callResetListenerOnDatabaseReset = true;
        this.file = context.getDatabasePath(getDatabaseName(str));
        this.instanceName = Utils.normalizeInstanceName(str);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        DatabaseResetListener databaseResetListener2 = this.databaseResetListener;
        if (databaseResetListener2 != null && this.callResetListenerOnDatabaseReset) {
            try {
                this.callResetListenerOnDatabaseReset = false;
                databaseResetListener2.onDatabaseReset(sQLiteDatabase);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("databaseReset callback failed during onCreate", new Object[0]), e);
            } catch (Throwable th) {
                this.callResetListenerOnDatabaseReset = true;
                throw th;
            }
            this.callResetListenerOnDatabaseReset = true;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            logger.e(TAG, "onUpgrade() with invalid oldVersion and newVersion");
            resetDatabase(sQLiteDatabase);
        } else if (i2 > 1) {
            if (i == 1) {
                sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
                if (i2 <= 2) {
                    return;
                }
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        AmplitudeLog amplitudeLog = logger;
                        String str = TAG;
                        amplitudeLog.e(str, "onUpgrade() with unknown oldVersion " + i);
                        resetDatabase(sQLiteDatabase);
                        return;
                    }
                    return;
                }
                sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
            }
            sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
            sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
            if (i2 <= 3) {
                return;
            }
            sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        }
    }

    private void resetDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identify_interceptor");
        onCreate(sQLiteDatabase);
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValue(String str, String str2) {
        long j;
        if (str2 == null) {
            j = deleteKeyFromTable("store", str);
        } else {
            j = insertOrReplaceKeyValueToTable("store", str, str2);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyLongValue(String str, Long l) {
        long j;
        if (l == null) {
            j = deleteKeyFromTable(LONG_STORE_TABLE_NAME, str);
        } else {
            j = insertOrReplaceKeyValueToTable(LONG_STORE_TABLE_NAME, str, l);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r2.isOpen() != false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r2.isOpen() != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long insertOrReplaceKeyValueToTable(java.lang.String r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 1
            r2 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003b, StackOverflowError -> 0x001a }
            long r6 = r5.insertOrReplaceKeyValueToTable(r2, r6, r7, r8)     // Catch:{ SQLiteException -> 0x003b, StackOverflowError -> 0x001a }
            if (r2 == 0) goto L_0x005b
            boolean r8 = r2.isOpen()     // Catch:{ all -> 0x0069 }
            if (r8 == 0) goto L_0x005b
            r5.close()     // Catch:{ all -> 0x0069 }
            goto L_0x005b
        L_0x0018:
            r6 = move-exception
            goto L_0x005d
        L_0x001a:
            r7 = move-exception
            com.amplitude.api.AmplitudeLog r8 = logger     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0018 }
            r1[r0] = r6     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = java.lang.String.format(r4, r1)     // Catch:{ all -> 0x0018 }
            r8.e(r3, r6, r7)     // Catch:{ all -> 0x0018 }
            r5.delete()     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0059
            boolean r6 = r2.isOpen()     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0059
        L_0x0037:
            r5.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0059
        L_0x003b:
            r7 = move-exception
            com.amplitude.api.AmplitudeLog r8 = logger     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0018 }
            r1[r0] = r6     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = java.lang.String.format(r4, r1)     // Catch:{ all -> 0x0018 }
            r8.e(r3, r6, r7)     // Catch:{ all -> 0x0018 }
            r5.delete()     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0059
            boolean r6 = r2.isOpen()     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0059
            goto L_0x0037
        L_0x0059:
            r6 = -1
        L_0x005b:
            monitor-exit(r5)
            return r6
        L_0x005d:
            if (r2 == 0) goto L_0x0068
            boolean r7 = r2.isOpen()     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x0068
            r5.close()     // Catch:{ all -> 0x0069 }
        L_0x0068:
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.insertOrReplaceKeyValueToTable(java.lang.String, java.lang.String, java.lang.Object):long");
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValueToTable(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws SQLiteException, StackOverflowError {
        long insertKeyValueContentValuesIntoTable;
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        insertKeyValueContentValuesIntoTable = insertKeyValueContentValuesIntoTable(sQLiteDatabase, str, contentValues);
        if (insertKeyValueContentValuesIntoTable == -1) {
            logger.w(TAG, "Insert failed");
        }
        return insertKeyValueContentValuesIntoTable;
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertKeyValueContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insertWithOnConflict(str, (String) null, contentValues, 5);
    }

    /* access modifiers changed from: package-private */
    public synchronized long deleteKeyFromTable(String str, String str2) {
        long j;
        try {
            j = (long) getWritableDatabase().delete(str, "key=?", new String[]{str2});
            close();
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), e);
            delete();
            close();
            j = -1;
            return j;
        } catch (StackOverflowError e2) {
            try {
                logger.e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), e2);
                delete();
                close();
                j = -1;
                return j;
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long addEvent(String str) {
        return addEventToTable(EVENT_TABLE_NAME, str);
    }

    /* access modifiers changed from: package-private */
    public synchronized long addIdentify(String str) {
        return addEventToTable(IDENTIFY_TABLE_NAME, str);
    }

    /* access modifiers changed from: package-private */
    public synchronized long addIdentifyInterceptor(String str) {
        return addEventToTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, str);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0033=Splitter:B:12:0x0033, B:20:0x0064=Splitter:B:20:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long addEventToTable(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 1
            r2 = -1
            android.database.sqlite.SQLiteDatabase r4 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x004f, StackOverflowError -> 0x0039 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x004f, StackOverflowError -> 0x0039 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x004f, StackOverflowError -> 0x0039 }
            java.lang.String r6 = "event"
            r5.put(r6, r9)     // Catch:{ SQLiteException -> 0x004f, StackOverflowError -> 0x0039 }
            long r4 = r7.insertEventContentValuesIntoTable(r4, r8, r5)     // Catch:{ SQLiteException -> 0x004f, StackOverflowError -> 0x0039 }
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x0033
            com.amplitude.api.AmplitudeLog r9 = logger     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            java.lang.String r2 = TAG     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            java.lang.String r3 = "Insert into %s failed"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            r6[r0] = r8     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            java.lang.String r3 = java.lang.String.format(r3, r6)     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            r9.w((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0030, StackOverflowError -> 0x002d }
            goto L_0x0033
        L_0x002d:
            r9 = move-exception
            r2 = r4
            goto L_0x003a
        L_0x0030:
            r9 = move-exception
            r2 = r4
            goto L_0x0050
        L_0x0033:
            r7.close()     // Catch:{ all -> 0x006e }
            goto L_0x0068
        L_0x0037:
            r8 = move-exception
            goto L_0x006a
        L_0x0039:
            r9 = move-exception
        L_0x003a:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0037 }
            java.lang.String r6 = "addEvent to %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0037 }
            r1[r0] = r8     // Catch:{ all -> 0x0037 }
            java.lang.String r8 = java.lang.String.format(r6, r1)     // Catch:{ all -> 0x0037 }
            r4.e(r5, r8, r9)     // Catch:{ all -> 0x0037 }
            r7.delete()     // Catch:{ all -> 0x0037 }
            goto L_0x0064
        L_0x004f:
            r9 = move-exception
        L_0x0050:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0037 }
            java.lang.String r6 = "addEvent to %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0037 }
            r1[r0] = r8     // Catch:{ all -> 0x0037 }
            java.lang.String r8 = java.lang.String.format(r6, r1)     // Catch:{ all -> 0x0037 }
            r4.e(r5, r8, r9)     // Catch:{ all -> 0x0037 }
            r7.delete()     // Catch:{ all -> 0x0037 }
        L_0x0064:
            r7.close()     // Catch:{ all -> 0x006e }
            r4 = r2
        L_0x0068:
            monitor-exit(r7)
            return r4
        L_0x006a:
            r7.close()     // Catch:{ all -> 0x006e }
            throw r8     // Catch:{ all -> 0x006e }
        L_0x006e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.addEventToTable(java.lang.String, java.lang.String):long");
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertEventContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insert(str, (String) null, contentValues);
    }

    /* access modifiers changed from: package-private */
    public synchronized String getValue(String str) {
        return (String) getValueFromTable("store", str);
    }

    /* access modifiers changed from: package-private */
    public synchronized Long getLongValue(String str) {
        return (Long) getValueFromTable(LONG_STORE_TABLE_NAME, str);
    }

    /* JADX WARNING: type inference failed for: r14v14, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r14v15, types: [java.lang.String] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062 A[SYNTHETIC, Splitter:B:32:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083 A[SYNTHETIC, Splitter:B:41:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f A[SYNTHETIC, Splitter:B:48:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a9 A[SYNTHETIC, Splitter:B:55:0x00a9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0052=Splitter:B:22:0x0052, B:45:0x0089=Splitter:B:45:0x0089, B:29:0x005d=Splitter:B:29:0x005d, B:38:0x006d=Splitter:B:38:0x006d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object getValueFromTable(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            monitor-enter(r13)
            r0 = 0
            r1 = 1
            r2 = 0
            android.database.sqlite.SQLiteDatabase r4 = r13.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            r3 = 2
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            java.lang.String r3 = "key"
            r6[r0] = r3     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            java.lang.String r3 = "value"
            r6[r1] = r3     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            java.lang.String r7 = "key = ?"
            java.lang.String[] r8 = new java.lang.String[]{r15}     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r3 = r13
            r5 = r14
            android.database.Cursor r15 = r3.queryDb(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0087, StackOverflowError -> 0x006b, IllegalStateException -> 0x005b, RuntimeException -> 0x0050, all -> 0x004e }
            boolean r3 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x004c, StackOverflowError -> 0x004a, IllegalStateException -> 0x0048, RuntimeException -> 0x0046 }
            if (r3 == 0) goto L_0x0040
            java.lang.String r3 = "store"
            boolean r3 = r14.equals(r3)     // Catch:{ SQLiteException -> 0x004c, StackOverflowError -> 0x004a, IllegalStateException -> 0x0048, RuntimeException -> 0x0046 }
            if (r3 == 0) goto L_0x0037
            java.lang.String r14 = r15.getString(r1)     // Catch:{ SQLiteException -> 0x004c, StackOverflowError -> 0x004a, IllegalStateException -> 0x0048, RuntimeException -> 0x0046 }
            goto L_0x003f
        L_0x0037:
            long r3 = r15.getLong(r1)     // Catch:{ SQLiteException -> 0x004c, StackOverflowError -> 0x004a, IllegalStateException -> 0x0048, RuntimeException -> 0x0046 }
            java.lang.Long r14 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x004c, StackOverflowError -> 0x004a, IllegalStateException -> 0x0048, RuntimeException -> 0x0046 }
        L_0x003f:
            r2 = r14
        L_0x0040:
            if (r15 == 0) goto L_0x0065
            r15.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0065
        L_0x0046:
            r14 = move-exception
            goto L_0x0052
        L_0x0048:
            r14 = move-exception
            goto L_0x005d
        L_0x004a:
            r3 = move-exception
            goto L_0x006d
        L_0x004c:
            r3 = move-exception
            goto L_0x0089
        L_0x004e:
            r14 = move-exception
            goto L_0x00a7
        L_0x0050:
            r14 = move-exception
            r15 = r2
        L_0x0052:
            convertIfCursorWindowException(r14)     // Catch:{ all -> 0x00a5 }
            if (r15 == 0) goto L_0x0065
            r15.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0065
        L_0x005b:
            r14 = move-exception
            r15 = r2
        L_0x005d:
            r13.handleIfCursorRowTooLargeException(r14)     // Catch:{ all -> 0x00a5 }
            if (r15 == 0) goto L_0x0065
            r15.close()     // Catch:{ all -> 0x0069 }
        L_0x0065:
            r13.close()     // Catch:{ all -> 0x0069 }
            goto L_0x00a3
        L_0x0069:
            r14 = move-exception
            goto L_0x00b0
        L_0x006b:
            r3 = move-exception
            r15 = r2
        L_0x006d:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = "getValue from %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
            r1[r0] = r14     // Catch:{ all -> 0x00a5 }
            java.lang.String r14 = java.lang.String.format(r6, r1)     // Catch:{ all -> 0x00a5 }
            r4.e(r5, r14, r3)     // Catch:{ all -> 0x00a5 }
            r13.delete()     // Catch:{ all -> 0x00a5 }
            if (r15 == 0) goto L_0x0065
            r15.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0065
        L_0x0087:
            r3 = move-exception
            r15 = r2
        L_0x0089:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = "getValue from %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
            r1[r0] = r14     // Catch:{ all -> 0x00a5 }
            java.lang.String r14 = java.lang.String.format(r6, r1)     // Catch:{ all -> 0x00a5 }
            r4.e(r5, r14, r3)     // Catch:{ all -> 0x00a5 }
            r13.delete()     // Catch:{ all -> 0x00a5 }
            if (r15 == 0) goto L_0x0065
            r15.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0065
        L_0x00a3:
            monitor-exit(r13)
            return r2
        L_0x00a5:
            r14 = move-exception
            r2 = r15
        L_0x00a7:
            if (r2 == 0) goto L_0x00ac
            r2.close()     // Catch:{ all -> 0x0069 }
        L_0x00ac:
            r13.close()     // Catch:{ all -> 0x0069 }
            throw r14     // Catch:{ all -> 0x0069 }
        L_0x00b0:
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getValueFromTable(java.lang.String, java.lang.String):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public synchronized List<JSONObject> getEvents(long j, long j2) throws JSONException {
        return getEventsFromTable(EVENT_TABLE_NAME, j, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<JSONObject> getIdentifys(long j, long j2) throws JSONException {
        return getEventsFromTable(IDENTIFY_TABLE_NAME, j, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<JSONObject> getIdentifyInterceptors(long j, long j2) throws JSONException {
        return getEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j, j2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        return getEventsRowByRowFromTable(r1, r2, r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<org.json.JSONObject> getEventsFromTable(java.lang.String r1, long r2, long r4) throws org.json.JSONException {
        /*
            r0 = this;
            monitor-enter(r0)
            java.util.List r1 = r0.getEventsBatchFromTable(r1, r2, r4)     // Catch:{ CursorWindowAllocationException -> 0x0009 }
            monitor-exit(r0)
            return r1
        L_0x0007:
            r1 = move-exception
            goto L_0x000f
        L_0x0009:
            java.util.List r1 = r0.getEventsRowByRowFromTable(r1, r2, r4)     // Catch:{ all -> 0x0007 }
            monitor-exit(r0)
            return r1
        L_0x000f:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsFromTable(java.lang.String, long, long):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0086, code lost:
        if (r15 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        if (r15 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        close();
        r1 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a2, code lost:
        if (r15 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        if (r15 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.json.JSONObject> getEventsBatchFromTable(java.lang.String r20, long r21, long r23) throws org.json.JSONException {
        /*
            r19 = this;
            r0 = r21
            r2 = r23
            java.lang.String r11 = "getEvents from %s failed"
            java.lang.String r4 = ""
            java.lang.String r5 = "id <= "
            java.util.LinkedList r12 = new java.util.LinkedList
            r12.<init>()
            r13 = 1
            r14 = 0
            r15 = 0
            android.database.sqlite.SQLiteDatabase r6 = r19.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r8 = "id"
            r7[r14] = r8     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r8 = "event"
            r7[r13] = r8     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r8 = 0
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0035
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r10.<init>(r5)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r10.append(r0)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r0 = r10.toString()     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r5 = r0
            goto L_0x0036
        L_0x0035:
            r5 = r15
        L_0x0036:
            r0 = 0
            r10 = 0
            r16 = 0
            java.lang.String r17 = "id ASC"
            int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x004f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r1.<init>(r4)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r18 = r1
            goto L_0x0051
        L_0x004f:
            r18 = r15
        L_0x0051:
            r1 = r19
            r2 = r6
            r3 = r20
            r4 = r7
            r6 = r0
            r7 = r10
            r8 = r16
            r9 = r17
            r10 = r18
            android.database.Cursor r15 = r1.queryDb(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
        L_0x0063:
            boolean r0 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            if (r0 == 0) goto L_0x0086
            long r0 = r15.getLong(r14)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r2 = r15.getString(r13)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            boolean r3 = com.amplitude.api.Utils.isEmptyString(r2)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            if (r3 == 0) goto L_0x0078
            goto L_0x0063
        L_0x0078:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r3.<init>(r2)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            java.lang.String r2 = "event_id"
            r3.put(r2, r0)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            r12.add(r3)     // Catch:{ SQLiteException -> 0x00c3, StackOverflowError -> 0x00ab, IllegalStateException -> 0x009c, RuntimeException -> 0x008d }
            goto L_0x0063
        L_0x0086:
            if (r15 == 0) goto L_0x0096
            goto L_0x0093
        L_0x0089:
            r0 = move-exception
            r1 = r19
            goto L_0x00dd
        L_0x008d:
            r0 = move-exception
            convertIfCursorWindowException(r0)     // Catch:{ all -> 0x0089 }
            if (r15 == 0) goto L_0x0096
        L_0x0093:
            r15.close()
        L_0x0096:
            r19.close()
            r1 = r19
            goto L_0x00db
        L_0x009c:
            r0 = move-exception
            r1 = r19
            r1.handleIfCursorRowTooLargeException(r0)     // Catch:{ all -> 0x00dc }
            if (r15 == 0) goto L_0x00a7
        L_0x00a4:
            r15.close()
        L_0x00a7:
            r19.close()
            goto L_0x00db
        L_0x00ab:
            r0 = move-exception
            r1 = r19
            com.amplitude.api.AmplitudeLog r2 = logger     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x00dc }
            r4[r14] = r20     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = java.lang.String.format(r11, r4)     // Catch:{ all -> 0x00dc }
            r2.e(r3, r4, r0)     // Catch:{ all -> 0x00dc }
            r19.delete()     // Catch:{ all -> 0x00dc }
            if (r15 == 0) goto L_0x00a7
            goto L_0x00a4
        L_0x00c3:
            r0 = move-exception
            r1 = r19
            com.amplitude.api.AmplitudeLog r2 = logger     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x00dc }
            r4[r14] = r20     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = java.lang.String.format(r11, r4)     // Catch:{ all -> 0x00dc }
            r2.e(r3, r4, r0)     // Catch:{ all -> 0x00dc }
            r19.delete()     // Catch:{ all -> 0x00dc }
            if (r15 == 0) goto L_0x00a7
            goto L_0x00a4
        L_0x00db:
            return r12
        L_0x00dc:
            r0 = move-exception
        L_0x00dd:
            if (r15 == 0) goto L_0x00e2
            r15.close()
        L_0x00e2:
            r19.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsBatchFromTable(java.lang.String, long, long):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ac, code lost:
        if (r16 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ae, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b6, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ce, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e2, code lost:
        if (r16 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:1:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a7 A[Catch:{ SQLiteException -> 0x009c, StackOverflowError -> 0x009a, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1, all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8 A[Catch:{ SQLiteException -> 0x009c, StackOverflowError -> 0x009a, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1, all -> 0x009e }, ExcHandler: IllegalStateException (e java.lang.IllegalStateException), Splitter:B:1:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cc A[Catch:{ SQLiteException -> 0x009c, StackOverflowError -> 0x009a, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1, all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f4 A[Catch:{ all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00a2=Splitter:B:40:0x00a2, B:51:0x00b7=Splitter:B:51:0x00b7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.json.JSONObject> getEventsRowByRowFromTable(java.lang.String r22, long r23, long r25) throws org.json.JSONException {
        /*
            r21 = this;
            r11 = r21
            r12 = r22
            r0 = r23
            r2 = r25
            java.lang.String r13 = "getEvents from %s failed"
            java.lang.String r4 = ""
            java.lang.String r5 = "id <= "
            java.util.LinkedList r14 = new java.util.LinkedList
            r14.<init>()
            r15 = 1
            r10 = 0
            r16 = 0
            android.database.sqlite.SQLiteDatabase r6 = r21.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00cd, StackOverflowError -> 0x00b5, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            java.lang.String[] r7 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00cd, StackOverflowError -> 0x00b5, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            java.lang.String r8 = "id"
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x00cd, StackOverflowError -> 0x00b5, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r8 = 0
            int r17 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r17 < 0) goto L_0x003d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r10.<init>(r5)     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r10.append(r0)     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            java.lang.String r0 = r10.toString()     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r5 = r0
            goto L_0x003f
        L_0x0035:
            r0 = move-exception
            r15 = 0
            goto L_0x00b7
        L_0x0039:
            r0 = move-exception
            r15 = 0
            goto L_0x00cf
        L_0x003d:
            r5 = r16
        L_0x003f:
            r0 = 0
            r10 = 0
            r18 = 0
            java.lang.String r19 = "id ASC"
            int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r1.<init>(r4)     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x0039, StackOverflowError -> 0x0035, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
            r20 = r1
            goto L_0x005a
        L_0x0058:
            r20 = r16
        L_0x005a:
            r1 = r21
            r2 = r6
            r3 = r22
            r4 = r7
            r6 = r0
            r7 = r10
            r8 = r18
            r9 = r19
            r15 = 0
            r10 = r20
            android.database.Cursor r1 = r1.queryDb(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x009c, StackOverflowError -> 0x009a, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a1 }
        L_0x006d:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0096, StackOverflowError -> 0x0092, IllegalStateException -> 0x008e, RuntimeException -> 0x008a, all -> 0x0085 }
            if (r0 == 0) goto L_0x007f
            long r2 = r1.getLong(r15)     // Catch:{ SQLiteException -> 0x0096, StackOverflowError -> 0x0092, IllegalStateException -> 0x008e, RuntimeException -> 0x008a, all -> 0x0085 }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0096, StackOverflowError -> 0x0092, IllegalStateException -> 0x008e, RuntimeException -> 0x008a, all -> 0x0085 }
            r14.add(r0)     // Catch:{ SQLiteException -> 0x0096, StackOverflowError -> 0x0092, IllegalStateException -> 0x008e, RuntimeException -> 0x008a, all -> 0x0085 }
            goto L_0x006d
        L_0x007f:
            if (r1 == 0) goto L_0x00b1
            r1.close()
            goto L_0x00b1
        L_0x0085:
            r0 = move-exception
            r16 = r1
            goto L_0x0111
        L_0x008a:
            r0 = move-exception
            r16 = r1
            goto L_0x00a2
        L_0x008e:
            r0 = move-exception
            r16 = r1
            goto L_0x00a9
        L_0x0092:
            r0 = move-exception
            r16 = r1
            goto L_0x00b7
        L_0x0096:
            r0 = move-exception
            r16 = r1
            goto L_0x00cf
        L_0x009a:
            r0 = move-exception
            goto L_0x00b7
        L_0x009c:
            r0 = move-exception
            goto L_0x00cf
        L_0x009e:
            r0 = move-exception
            goto L_0x0111
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            convertIfCursorWindowException(r0)     // Catch:{ all -> 0x009e }
            if (r16 == 0) goto L_0x00b1
            goto L_0x00ae
        L_0x00a8:
            r0 = move-exception
        L_0x00a9:
            r11.handleIfCursorRowTooLargeException(r0)     // Catch:{ all -> 0x009e }
            if (r16 == 0) goto L_0x00b1
        L_0x00ae:
            r16.close()
        L_0x00b1:
            r21.close()
            goto L_0x00e5
        L_0x00b5:
            r0 = move-exception
            r15 = r10
        L_0x00b7:
            com.amplitude.api.AmplitudeLog r1 = logger     // Catch:{ all -> 0x009e }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x009e }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009e }
            r3[r15] = r12     // Catch:{ all -> 0x009e }
            java.lang.String r3 = java.lang.String.format(r13, r3)     // Catch:{ all -> 0x009e }
            r1.e(r2, r3, r0)     // Catch:{ all -> 0x009e }
            r21.delete()     // Catch:{ all -> 0x009e }
            if (r16 == 0) goto L_0x00b1
            goto L_0x00ae
        L_0x00cd:
            r0 = move-exception
            r15 = r10
        L_0x00cf:
            com.amplitude.api.AmplitudeLog r1 = logger     // Catch:{ all -> 0x009e }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x009e }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009e }
            r3[r15] = r12     // Catch:{ all -> 0x009e }
            java.lang.String r3 = java.lang.String.format(r13, r3)     // Catch:{ all -> 0x009e }
            r1.e(r2, r3, r0)     // Catch:{ all -> 0x009e }
            r21.delete()     // Catch:{ all -> 0x009e }
            if (r16 == 0) goto L_0x00b1
            goto L_0x00ae
        L_0x00e5:
            java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x010c }
            r0.<init>()     // Catch:{ all -> 0x010c }
            java.util.Iterator r1 = r14.iterator()     // Catch:{ all -> 0x010c }
        L_0x00ee:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x010c }
            if (r2 == 0) goto L_0x0108
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x010c }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x010c }
            long r2 = r2.longValue()     // Catch:{ all -> 0x010c }
            org.json.JSONObject r2 = r11.getEventFromTable(r12, r2)     // Catch:{ all -> 0x010c }
            if (r2 == 0) goto L_0x00ee
            r0.add(r2)     // Catch:{ all -> 0x010c }
            goto L_0x00ee
        L_0x0108:
            r21.close()
            return r0
        L_0x010c:
            r0 = move-exception
            r21.close()
            throw r0
        L_0x0111:
            if (r16 == 0) goto L_0x0116
            r16.close()
        L_0x0116:
            r21.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsRowByRowFromTable(java.lang.String, long, long):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v16, resolved type: org.json.JSONObject} */
    /* JADX WARNING: type inference failed for: r16v2, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r16v15 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0088, code lost:
        if (r16 == null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c4, code lost:
        if (r16 == null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0081 A[Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079, all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ac A[Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079, all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cb A[SYNTHETIC, Splitter:B:64:0x00cb] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x0096=Splitter:B:53:0x0096, B:39:0x007c=Splitter:B:39:0x007c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject getEventFromTable(java.lang.String r18, long r19) throws org.json.JSONException {
        /*
            r17 = this;
            r11 = r17
            r12 = r19
            java.lang.String r0 = "id = "
            monitor-enter(r17)
            r14 = 1
            r15 = 0
            r16 = 0
            android.database.sqlite.SQLiteDatabase r2 = r17.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            java.lang.String[] r4 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            java.lang.String r1 = "event"
            r4[r15] = r1     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            r1.<init>(r0)     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            r1.append(r12)     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            java.lang.String r5 = r1.toString()     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r1 = r17
            r3 = r18
            android.database.Cursor r1 = r1.queryDb(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00ad, StackOverflowError -> 0x0093, IllegalStateException -> 0x0082, RuntimeException -> 0x0079 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0071, StackOverflowError -> 0x006b, IllegalStateException -> 0x0065, RuntimeException -> 0x005f, all -> 0x005a }
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = r1.getString(r15)     // Catch:{ SQLiteException -> 0x0071, StackOverflowError -> 0x006b, IllegalStateException -> 0x0065, RuntimeException -> 0x005f, all -> 0x005a }
            boolean r2 = com.amplitude.api.Utils.isEmptyString(r0)     // Catch:{ SQLiteException -> 0x0071, StackOverflowError -> 0x006b, IllegalStateException -> 0x0065, RuntimeException -> 0x005f, all -> 0x005a }
            if (r2 != 0) goto L_0x0053
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ SQLiteException -> 0x0071, StackOverflowError -> 0x006b, IllegalStateException -> 0x0065, RuntimeException -> 0x005f, all -> 0x005a }
            r2.<init>(r0)     // Catch:{ SQLiteException -> 0x0071, StackOverflowError -> 0x006b, IllegalStateException -> 0x0065, RuntimeException -> 0x005f, all -> 0x005a }
            java.lang.String r0 = "event_id"
            r2.put(r0, r12)     // Catch:{ SQLiteException -> 0x0051, StackOverflowError -> 0x004f, IllegalStateException -> 0x004d, RuntimeException -> 0x004b, all -> 0x005a }
            r16 = r2
            goto L_0x0053
        L_0x004b:
            r0 = move-exception
            goto L_0x0062
        L_0x004d:
            r0 = move-exception
            goto L_0x0068
        L_0x004f:
            r0 = move-exception
            goto L_0x006e
        L_0x0051:
            r0 = move-exception
            goto L_0x0074
        L_0x0053:
            if (r1 == 0) goto L_0x00c7
            r1.close()     // Catch:{ all -> 0x008e }
            goto L_0x00c7
        L_0x005a:
            r0 = move-exception
            r16 = r1
            goto L_0x00c9
        L_0x005f:
            r0 = move-exception
            r2 = r16
        L_0x0062:
            r16 = r1
            goto L_0x007c
        L_0x0065:
            r0 = move-exception
            r2 = r16
        L_0x0068:
            r16 = r1
            goto L_0x0085
        L_0x006b:
            r0 = move-exception
            r2 = r16
        L_0x006e:
            r16 = r1
            goto L_0x0096
        L_0x0071:
            r0 = move-exception
            r2 = r16
        L_0x0074:
            r16 = r1
            goto L_0x00b0
        L_0x0077:
            r0 = move-exception
            goto L_0x00c9
        L_0x0079:
            r0 = move-exception
            r2 = r16
        L_0x007c:
            convertIfCursorWindowException(r0)     // Catch:{ all -> 0x0077 }
            if (r16 == 0) goto L_0x0090
            goto L_0x008a
        L_0x0082:
            r0 = move-exception
            r2 = r16
        L_0x0085:
            r11.handleIfCursorRowTooLargeException(r0)     // Catch:{ all -> 0x0077 }
            if (r16 == 0) goto L_0x0090
        L_0x008a:
            r16.close()     // Catch:{ all -> 0x008e }
            goto L_0x0090
        L_0x008e:
            r0 = move-exception
            goto L_0x00cf
        L_0x0090:
            r16 = r2
            goto L_0x00c7
        L_0x0093:
            r0 = move-exception
            r2 = r16
        L_0x0096:
            com.amplitude.api.AmplitudeLog r1 = logger     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "getEvent from %s failed"
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0077 }
            r5[r15] = r18     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0077 }
            r1.e(r3, r4, r0)     // Catch:{ all -> 0x0077 }
            r17.delete()     // Catch:{ all -> 0x0077 }
            if (r16 == 0) goto L_0x0090
            goto L_0x008a
        L_0x00ad:
            r0 = move-exception
            r2 = r16
        L_0x00b0:
            com.amplitude.api.AmplitudeLog r1 = logger     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "getEvent from %s failed"
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0077 }
            r5[r15] = r18     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0077 }
            r1.e(r3, r4, r0)     // Catch:{ all -> 0x0077 }
            r17.delete()     // Catch:{ all -> 0x0077 }
            if (r16 == 0) goto L_0x0090
            goto L_0x008a
        L_0x00c7:
            monitor-exit(r17)
            return r16
        L_0x00c9:
            if (r16 == 0) goto L_0x00ce
            r16.close()     // Catch:{ all -> 0x008e }
        L_0x00ce:
            throw r0     // Catch:{ all -> 0x008e }
        L_0x00cf:
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventFromTable(java.lang.String, long):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public synchronized long getEventCount() {
        return getEventCountFromTable(EVENT_TABLE_NAME);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getIdentifyCount() {
        return getEventCountFromTable(IDENTIFY_TABLE_NAME);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getTotalEventCount() {
        return getEventCount() + getIdentifyCount();
    }

    /* access modifiers changed from: package-private */
    public synchronized long getIdentifyInterceptorCount() {
        return getEventCountFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME);
    }

    private synchronized long getEventCountFromTable(String str) {
        long j;
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            SQLiteStatement compileStatement = readableDatabase.compileStatement("SELECT COUNT(*) FROM " + str);
            j = compileStatement.simpleQueryForLong();
            if (compileStatement != null) {
                compileStatement.close();
            }
            close();
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), e);
            delete();
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            close();
            j = 0;
            return j;
        } catch (StackOverflowError e2) {
            try {
                logger.e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), e2);
                delete();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                j = 0;
                return j;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                throw th;
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long getNthEventId(long j) {
        return getNthEventIdFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getNthIdentifyId(long j) {
        return getNthEventIdFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getLastIdentifyInterceptorId() {
        return getNthEventIdFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, 1, "DESC");
    }

    private synchronized long getNthEventIdFromTable(String str, long j) {
        return getNthEventIdFromTable(str, j, "ASC");
    }

    private synchronized long getNthEventIdFromTable(String str, long j, String str2) {
        long j2;
        j2 = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            sQLiteStatement = readableDatabase.compileStatement("SELECT id FROM " + str + " ORDER BY id " + str2 + " LIMIT 1 OFFSET " + (j - 1));
            try {
                j2 = sQLiteStatement.simpleQueryForLong();
            } catch (SQLiteDoneException e) {
                logger.w(TAG, (Throwable) e);
            }
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
        } catch (SQLiteException e2) {
            logger.e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e2);
            delete();
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
        } catch (StackOverflowError e3) {
            try {
                logger.e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e3);
                delete();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                throw th;
            }
        }
        close();
        return j2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeEvents(long j) {
        removeEventsFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentifys(long j) {
        removeEventsFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentifyInterceptors(long j) {
        removeEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventsFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(str, "id <= " + j, (String[]) null);
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), e);
            delete();
        } catch (StackOverflowError e2) {
            try {
                logger.e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), e2);
                delete();
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeEvent(long j) {
        removeEventFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentify(long j) {
        removeEventFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentifyIntercept(long j) {
        removeEventFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(str, "id = " + j, (String[]) null);
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), e);
            delete();
        } catch (StackOverflowError e2) {
            try {
                logger.e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), e2);
                delete();
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c7, code lost:
        if (r1.isOpen() != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e5, code lost:
        if (r1.isOpen() != false) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void delete() {
        /*
            r8 = this;
            java.lang.String r0 = "databaseReset callback failed during delete"
            r1 = 0
            r2 = 0
            r3 = 1
            r8.close()     // Catch:{ SecurityException -> 0x005a }
            java.io.File r4 = r8.file     // Catch:{ SecurityException -> 0x005a }
            r4.delete()     // Catch:{ SecurityException -> 0x005a }
            com.amplitude.api.DatabaseResetListener r4 = r8.databaseResetListener
            if (r4 == 0) goto L_0x00ab
            boolean r4 = r8.callResetListenerOnDatabaseReset
            if (r4 == 0) goto L_0x00ab
            r8.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0031 }
            com.amplitude.api.DatabaseResetListener r4 = r8.databaseResetListener     // Catch:{ SQLiteException -> 0x0031 }
            r4.onDatabaseReset(r1)     // Catch:{ SQLiteException -> 0x0031 }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00ab
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00ab
        L_0x002a:
            r8.close()
            goto L_0x00ab
        L_0x002f:
            r0 = move-exception
            goto L_0x004a
        L_0x0031:
            r4 = move-exception
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x002f }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x002f }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x002f }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x002f }
            r5.e(r6, r0, r4)     // Catch:{ all -> 0x002f }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00ab
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00ab
            goto L_0x002a
        L_0x004a:
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x0057
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x0057
            r8.close()
        L_0x0057:
            throw r0
        L_0x0058:
            r4 = move-exception
            goto L_0x00ac
        L_0x005a:
            r4 = move-exception
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x0058 }
            java.lang.String r7 = "delete failed"
            r5.e(r6, r7, r4)     // Catch:{ all -> 0x0058 }
            com.amplitude.api.DatabaseResetListener r4 = r8.databaseResetListener
            if (r4 == 0) goto L_0x00ab
            boolean r4 = r8.callResetListenerOnDatabaseReset
            if (r4 == 0) goto L_0x00ab
            r8.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0084 }
            com.amplitude.api.DatabaseResetListener r4 = r8.databaseResetListener     // Catch:{ SQLiteException -> 0x0084 }
            r4.onDatabaseReset(r1)     // Catch:{ SQLiteException -> 0x0084 }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00ab
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00ab
            goto L_0x002a
        L_0x0082:
            r0 = move-exception
            goto L_0x009d
        L_0x0084:
            r4 = move-exception
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x0082 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x0082 }
            r5.e(r6, r0, r4)     // Catch:{ all -> 0x0082 }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00ab
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00ab
            goto L_0x002a
        L_0x009d:
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00aa
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x00aa
            r8.close()
        L_0x00aa:
            throw r0
        L_0x00ab:
            return
        L_0x00ac:
            com.amplitude.api.DatabaseResetListener r5 = r8.databaseResetListener
            if (r5 == 0) goto L_0x00f6
            boolean r5 = r8.callResetListenerOnDatabaseReset
            if (r5 == 0) goto L_0x00f6
            r8.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00cf }
            com.amplitude.api.DatabaseResetListener r5 = r8.databaseResetListener     // Catch:{ SQLiteException -> 0x00cf }
            r5.onDatabaseReset(r1)     // Catch:{ SQLiteException -> 0x00cf }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00f6
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00f6
        L_0x00c9:
            r8.close()
            goto L_0x00f6
        L_0x00cd:
            r0 = move-exception
            goto L_0x00e8
        L_0x00cf:
            r5 = move-exception
            com.amplitude.api.AmplitudeLog r6 = logger     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x00cd }
            r6.e(r7, r0, r5)     // Catch:{ all -> 0x00cd }
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00f6
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x00f6
            goto L_0x00c9
        L_0x00e8:
            r8.callResetListenerOnDatabaseReset = r3
            if (r1 == 0) goto L_0x00f5
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x00f5
            r8.close()
        L_0x00f5:
            throw r0
        L_0x00f6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.delete():void");
    }

    /* access modifiers changed from: package-private */
    public boolean dbFileExists() {
        return this.file.exists();
    }

    /* access modifiers changed from: package-private */
    public Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    private void handleIfCursorRowTooLargeException(IllegalStateException illegalStateException) {
        String message = illegalStateException.getMessage();
        if (Utils.isEmptyString(message) || !message.contains("Couldn't read") || !message.contains("CursorWindow")) {
            throw illegalStateException;
        }
        delete();
    }

    private static void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (Utils.isEmptyString(message) || (!message.startsWith("Cursor window allocation of") && !message.startsWith("Could not allocate CursorWindow"))) {
            throw runtimeException;
        }
        throw new CursorWindowAllocationException(message);
    }
}
