package com.onesignal.core.internal.database.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import com.onesignal.session.internal.outcomes.impl.OutcomesDbContract;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0010\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J \u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J{\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b0(H\u0016¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\rH\u0002J7\u0010-\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/onesignal/core/internal/database/impl/OSDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lcom/onesignal/core/internal/database/IDatabase;", "_outcomeTableProvider", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;", "context", "Landroid/content/Context;", "version", "", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;Landroid/content/Context;I)V", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getSQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getSQLiteDatabaseWithRetries", "insert", "nullColumnHack", "values", "Landroid/content/ContentValues;", "insertOrThrow", "internalOnUpgrade", "db", "oldVersion", "newVersion", "onCreate", "onDowngrade", "onUpgrade", "query", "columns", "groupBy", "having", "orderBy", "limit", "action", "Lkotlin/Function1;", "Lcom/onesignal/core/internal/database/ICursor;", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "safeExecSQL", "sql", "update", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "upgradeFromV5ToV6", "upgradeToV2", "upgradeToV3", "upgradeToV4", "upgradeToV5", "upgradeToV7", "upgradeToV8", "upgradeToV9", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OSDatabase.kt */
public class OSDatabase extends SQLiteOpenHelper implements IDatabase {
    private static final String COMMA_SEP = ",";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATABASE_NAME = "OneSignal.db";
    private static final int DB_OPEN_RETRY_BACKOFF = 400;
    private static final int DB_OPEN_RETRY_MAX = 5;
    private static final int DB_VERSION = 9;
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    private static final Object LOCK = new Object();
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);";
    private static final String SQL_CREATE_IN_APP_MESSAGE_ENTRIES = "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);";
    private static final String[] SQL_INDEX_ENTRIES = {OneSignalDbContract.NotificationTable.INDEX_CREATE_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_COLLAPSE_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_CREATED_TIME, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME};
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private final OutcomeTableProvider _outcomeTableProvider;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OSDatabase(OutcomeTableProvider outcomeTableProvider, Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(outcomeTableProvider, context, (i2 & 4) != 0 ? 9 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OSDatabase(OutcomeTableProvider outcomeTableProvider, Context context, int i) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, i);
        Intrinsics.checkNotNullParameter(outcomeTableProvider, "_outcomeTableProvider");
        this._outcomeTableProvider = outcomeTableProvider;
    }

    private final SQLiteDatabase getSQLiteDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (LOCK) {
            try {
                writableDatabase = getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                writableDatabase\n            }");
            } catch (SQLiteCantOpenDatabaseException e) {
                throw e;
            } catch (SQLiteDatabaseLockedException e2) {
                throw e2;
            }
        }
        return writableDatabase;
    }

    private final SQLiteDatabase getSQLiteDatabaseWithRetries() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            int i = 0;
            while (true) {
                try {
                    sQLiteDatabase = getSQLiteDatabase();
                } catch (SQLiteCantOpenDatabaseException e) {
                    i++;
                    if (i < 5) {
                        SystemClock.sleep((long) (i * 400));
                    } else {
                        throw e;
                    }
                } catch (SQLiteDatabaseLockedException e2) {
                    i++;
                    if (i < 5) {
                        SystemClock.sleep((long) (i * 400));
                    } else {
                        throw e2;
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, Function1<? super ICursor, Unit> function1) {
        Cursor cursor;
        Throwable th;
        Function1<? super ICursor, Unit> function12 = function1;
        String str7 = str;
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(function12, "action");
        synchronized (LOCK) {
            if (str6 == null) {
                cursor = getSQLiteDatabaseWithRetries().query(str, strArr, str2, strArr2, str3, str4, str5);
                Intrinsics.checkNotNullExpressionValue(cursor, "getSQLiteDatabaseWithRet…By,\n                    )");
            } else {
                cursor = getSQLiteDatabaseWithRetries().query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                Intrinsics.checkNotNullExpressionValue(cursor, "getSQLiteDatabaseWithRet…it,\n                    )");
            }
            Unit unit = Unit.INSTANCE;
        }
        Closeable closeable = cursor;
        try {
            function12.invoke(new DatabaseCursor((Cursor) closeable));
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(closeable, (Throwable) null);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            CloseableKt.closeFinally(closeable, th);
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r7 = "Error closing transaction! ";
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a9, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b0, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r7 = "Error closing transaction! ";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0019, B:18:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insert(java.lang.String r6, java.lang.String r7, android.content.ContentValues r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Error under inserting transaction under table: "
            java.lang.String r1 = "Error inserting on table: "
            java.lang.String r2 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.Object r2 = LOCK
            monitor-enter(r2)
            android.database.sqlite.SQLiteDatabase r3 = r5.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00b1 }
            r3.beginTransaction()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.insert(r6, r7, r8)     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0028, SQLiteException -> 0x001e }
            goto L_0x0097
        L_0x001e:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x0023:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0028:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x002d:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0031:
            r6 = move-exception
            goto L_0x009b
        L_0x0033:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r0)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with nullColumnHack: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and values: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r1)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x005f, SQLiteException -> 0x0059 }
            goto L_0x0097
        L_0x0059:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x005f:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0065:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r1)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with nullColumnHack: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and values: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r0)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0091, SQLiteException -> 0x008b }
            goto L_0x0097
        L_0x008b:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x0091:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0097:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b1 }
            monitor-exit(r2)
            return
        L_0x009b:
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x00a8, SQLiteException -> 0x009f }
            goto L_0x00b0
        L_0x009f:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b0
        L_0x00a8:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
        L_0x00b0:
            throw r6     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.database.impl.OSDatabase.insert(java.lang.String, java.lang.String, android.content.ContentValues):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r7 = "Error closing transaction! ";
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a9, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b0, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r7 = "Error closing transaction! ";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0019, B:18:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insertOrThrow(java.lang.String r6, java.lang.String r7, android.content.ContentValues r8) throws android.database.SQLException {
        /*
            r5 = this;
            java.lang.String r0 = "Error under inserting or throw transaction under table: "
            java.lang.String r1 = "Error inserting or throw on table: "
            java.lang.String r2 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.Object r2 = LOCK
            monitor-enter(r2)
            android.database.sqlite.SQLiteDatabase r3 = r5.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00b1 }
            r3.beginTransaction()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.insertOrThrow(r6, r7, r8)     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0028, SQLiteException -> 0x001e }
            goto L_0x0097
        L_0x001e:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x0023:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0028:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x002d:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0031:
            r6 = move-exception
            goto L_0x009b
        L_0x0033:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r0)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with nullColumnHack: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and values: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r1)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x005f, SQLiteException -> 0x0059 }
            goto L_0x0097
        L_0x0059:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x005f:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0065:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r1)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with nullColumnHack: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and values: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r0)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0091, SQLiteException -> 0x008b }
            goto L_0x0097
        L_0x008b:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x0091:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0097:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b1 }
            monitor-exit(r2)
            return
        L_0x009b:
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x00a8, SQLiteException -> 0x009f }
            goto L_0x00b0
        L_0x009f:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b0
        L_0x00a8:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
        L_0x00b0:
            throw r6     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.database.impl.OSDatabase.insertOrThrow(java.lang.String, java.lang.String, android.content.ContentValues):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r7 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r7 = "Error closing transaction! ";
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r4.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c2, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c9, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:9:0x0032, B:21:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(java.lang.String r6, android.content.ContentValues r7, java.lang.String r8, java.lang.String[] r9) {
        /*
            r5 = this;
            java.lang.String r0 = "Error under update transaction under table: "
            java.lang.String r1 = "Error updating on table: "
            java.lang.String r2 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = r7.toString()
            java.lang.String r3 = "values.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            r3 = 0
            if (r2 != 0) goto L_0x0021
            return r3
        L_0x0021:
            java.lang.Object r2 = LOCK
            monitor-enter(r2)
            android.database.sqlite.SQLiteDatabase r4 = r5.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00ca }
            r4.beginTransaction()     // Catch:{ SQLiteException -> 0x007e, IllegalStateException -> 0x004c }
            int r3 = r4.update(r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007e, IllegalStateException -> 0x004c }
            r4.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x007e, IllegalStateException -> 0x004c }
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x0041, SQLiteException -> 0x0037 }
            goto L_0x00b0
        L_0x0037:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
        L_0x003c:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00ca }
            goto L_0x00b0
        L_0x0041:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
        L_0x0046:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00ca }
            goto L_0x00b0
        L_0x004a:
            r6 = move-exception
            goto L_0x00b4
        L_0x004c:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r1.<init>(r0)     // Catch:{ all -> 0x004a }
            r1.append(r6)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = " with whereClause: "
            r1.append(r6)     // Catch:{ all -> 0x004a }
            r1.append(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = " and whereArgs: "
            r1.append(r6)     // Catch:{ all -> 0x004a }
            r1.append(r9)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x004a }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x004a }
            com.onesignal.debug.internal.logging.Logging.error(r6, r7)     // Catch:{ all -> 0x004a }
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x0078, SQLiteException -> 0x0072 }
            goto L_0x00b0
        L_0x0072:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
            goto L_0x003c
        L_0x0078:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
            goto L_0x0046
        L_0x007e:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r0.<init>(r1)     // Catch:{ all -> 0x004a }
            r0.append(r6)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = " with whereClause: "
            r0.append(r6)     // Catch:{ all -> 0x004a }
            r0.append(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = " and whereArgs: "
            r0.append(r6)     // Catch:{ all -> 0x004a }
            r0.append(r9)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x004a }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x004a }
            com.onesignal.debug.internal.logging.Logging.error(r6, r7)     // Catch:{ all -> 0x004a }
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x00aa, SQLiteException -> 0x00a4 }
            goto L_0x00b0
        L_0x00a4:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
            goto L_0x003c
        L_0x00aa:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00ca }
            goto L_0x0046
        L_0x00b0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ca }
            monitor-exit(r2)
            return r3
        L_0x00b4:
            r4.endTransaction()     // Catch:{ IllegalStateException -> 0x00c1, SQLiteException -> 0x00b8 }
            goto L_0x00c9
        L_0x00b8:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00ca }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00ca }
            goto L_0x00c9
        L_0x00c1:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00ca }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00ca }
        L_0x00c9:
            throw r6     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.database.impl.OSDatabase.update(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r7 = "Error closing transaction! ";
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a9, code lost:
        com.onesignal.debug.internal.logging.Logging.error("Error closing transaction! ", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b0, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r7 = "Error closing transaction! ";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0019, B:18:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(java.lang.String r6, java.lang.String r7, java.lang.String[] r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Error under delete transaction under table: "
            java.lang.String r1 = "Error deleting on table: "
            java.lang.String r2 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.Object r2 = LOCK
            monitor-enter(r2)
            android.database.sqlite.SQLiteDatabase r3 = r5.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00b1 }
            r3.beginTransaction()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.delete(r6, r7, r8)     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0065, IllegalStateException -> 0x0033 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0028, SQLiteException -> 0x001e }
            goto L_0x0097
        L_0x001e:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x0023:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0028:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
        L_0x002d:
            com.onesignal.debug.internal.logging.Logging.error(r7, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0097
        L_0x0031:
            r6 = move-exception
            goto L_0x009b
        L_0x0033:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r0)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with whereClause: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and whereArgs: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r1)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x005f, SQLiteException -> 0x0059 }
            goto L_0x0097
        L_0x0059:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x005f:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0065:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r1)     // Catch:{ all -> 0x0031 }
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " with whereClause: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = " and whereArgs: "
            r4.append(r6)     // Catch:{ all -> 0x0031 }
            r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.error(r6, r0)     // Catch:{ all -> 0x0031 }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0091, SQLiteException -> 0x008b }
            goto L_0x0097
        L_0x008b:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x0023
        L_0x0091:
            r6 = move-exception
            java.lang.String r7 = "Error closing transaction! "
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00b1 }
            goto L_0x002d
        L_0x0097:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b1 }
            monitor-exit(r2)
            return
        L_0x009b:
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x00a8, SQLiteException -> 0x009f }
            goto L_0x00b0
        L_0x009f:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b0
        L_0x00a8:
            r7 = move-exception
            java.lang.String r8 = "Error closing transaction! "
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            com.onesignal.debug.internal.logging.Logging.error(r8, r7)     // Catch:{ all -> 0x00b1 }
        L_0x00b0:
            throw r6     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.database.impl.OSDatabase.delete(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sQLiteDatabase.execSQL(OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V4);
        sQLiteDatabase.execSQL(OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2);
        sQLiteDatabase.execSQL(SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
        for (String execSQL : SQL_INDEX_ENTRIES) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
        Logging.debug$default("OneSignal Database onUpgrade from: " + i + " to: " + i2, (Throwable) null, 2, (Object) null);
        try {
            internalOnUpgrade(sQLiteDatabase, i, i2);
        } catch (SQLiteException e) {
            Logging.error("Error in upgrade, migration may have already run! Skipping!", e);
        }
    }

    private final synchronized void internalOnUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2 && i2 >= 2) {
            try {
                upgradeToV2(sQLiteDatabase);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i < 3 && i2 >= 3) {
            upgradeToV3(sQLiteDatabase);
        }
        if (i < 4 && i2 >= 4) {
            upgradeToV4(sQLiteDatabase);
        }
        if (i < 5 && i2 >= 5) {
            upgradeToV5(sQLiteDatabase);
        }
        if (i == 5 && i2 >= 6) {
            upgradeFromV5ToV6(sQLiteDatabase);
        }
        if (i < 7 && i2 >= 7) {
            upgradeToV7(sQLiteDatabase);
        }
        if (i < 8 && i2 >= 8) {
            upgradeToV8(sQLiteDatabase);
        }
        if (i < 9 && i2 >= 9) {
            upgradeToV9(sQLiteDatabase);
        }
    }

    private final void upgradeToV2(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID);
    }

    private final void upgradeToV3(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        safeExecSQL(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME);
    }

    private final void upgradeToV4(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V1);
    }

    private final void upgradeToV5(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V1);
        upgradeFromV5ToV6(sQLiteDatabase);
    }

    private final void upgradeFromV5ToV6(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private final void upgradeToV7(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
    }

    private final void safeExecSQL(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    private final synchronized void upgradeToV8(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision2To3(sQLiteDatabase);
        this._outcomeTableProvider.upgradeCacheOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private final void upgradeToV9(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision3To4(sQLiteDatabase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDowngrade(android.database.sqlite.SQLiteDatabase r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r8 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r8 = "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state."
            r9 = 0
            r0 = 2
            com.onesignal.debug.internal.logging.Logging.warn$default(r8, r9, r0, r9)
            java.lang.String r8 = "SELECT name FROM sqlite_master WHERE type='table'"
            android.database.Cursor r8 = r7.rawQuery(r8, r9)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r1 = r8
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x006c }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x006c }
            int r3 = r1.getCount()     // Catch:{ all -> 0x006c }
            r2.<init>(r3)     // Catch:{ all -> 0x006c }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x006c }
        L_0x0022:
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x006c }
            r4 = 0
            if (r3 == 0) goto L_0x0036
            java.lang.String r3 = r1.getString(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "it.getString(0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x006c }
            r2.add(r3)     // Catch:{ all -> 0x006c }
            goto L_0x0022
        L_0x0036:
            java.util.Iterator r1 = r2.iterator()     // Catch:{ all -> 0x006c }
        L_0x003a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x0063
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x006c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "sqlite_"
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r2, r3, r4, r0, r9)     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x003a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r3.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "DROP TABLE IF EXISTS "
            r3.append(r5)     // Catch:{ all -> 0x006c }
            r3.append(r2)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x006c }
            r7.execSQL(r2)     // Catch:{ all -> 0x006c }
            goto L_0x003a
        L_0x0063:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006c }
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            r6.onCreate(r7)
            return
        L_0x006c:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x006e }
        L_0x006e:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.database.impl.OSDatabase.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/database/impl/OSDatabase$Companion;", "", "()V", "COMMA_SEP", "", "DATABASE_NAME", "DB_OPEN_RETRY_BACKOFF", "", "DB_OPEN_RETRY_MAX", "DB_VERSION", "DEFAULT_TTL_IF_NOT_IN_PAYLOAD", "FLOAT_TYPE", "INTEGER_PRIMARY_KEY_TYPE", "INT_TYPE", "LOCK", "SQL_CREATE_ENTRIES", "SQL_CREATE_IN_APP_MESSAGE_ENTRIES", "SQL_INDEX_ENTRIES", "", "[Ljava/lang/String;", "TEXT_TYPE", "TIMESTAMP_TYPE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OSDatabase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
