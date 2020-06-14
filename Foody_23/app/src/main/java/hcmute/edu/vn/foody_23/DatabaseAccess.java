package hcmute.edu.vn.foody_23;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the databases connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
        this.database = openHelper.getReadableDatabase();
    }

    /**
     * Close the databases connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    /**
     * Read all quotes from the databases.
     *
     * @return a List of quotes
     */

    public List<MonAn> getMonAn() {
        List<MonAn> list = new ArrayList<>();
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("select Store.Id,Store.Description,Store.Name," +
                "Image.HinhAnh from Store inner join Image on Image.Store_Id = Store.Id where " +
                "Image.Kieuhinhanh ='thumb'", null);
        //cursor.getReadableDatabase();
         cursor.moveToFirst();
        list.clear();
            while (!cursor.isAfterLast()) {
                // MonAn monAn = new MonAn();
                String Desc = cursor.getString(1);
                String Name = cursor.getString(2);
                byte[] Img = cursor.getBlob(3);
                MonAn monAn = new MonAn(Name, Desc, Img);
//            monAn.setTitle(cursor.getString(0));
//            monAn.setDescription(cursor.getString(1));
//            monAn.setThumbnail(cursor.getBlob(2));
                list.add(monAn);
                cursor.moveToNext();
            }
        cursor.close();
        return list;
    }
}
