package com.cerengumus.bitcointrackerapp.data.local.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CoinsListDao_Impl implements CoinsListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CoinsListEntity> __insertionAdapterOfCoinsListEntity;

  private final EntityDeletionOrUpdateAdapter<CoinsListEntity> __updateAdapterOfCoinsListEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CoinsListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCoinsListEntity = new EntityInsertionAdapter<CoinsListEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `coins_list` (`symbol`,`id`,`name`,`price`,`changePercent`,`image`,`isFavourite`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoinsListEntity value) {
        if (value.getSymbol() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSymbol());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPrice());
        }
        if (value.getChangePercent() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getChangePercent());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        final int _tmp = value.isFavourite() ? 1 : 0;
        stmt.bindLong(7, _tmp);
      }
    };
    this.__updateAdapterOfCoinsListEntity = new EntityDeletionOrUpdateAdapter<CoinsListEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `coins_list` SET `symbol` = ?,`id` = ?,`name` = ?,`price` = ?,`changePercent` = ?,`image` = ?,`isFavourite` = ? WHERE `symbol` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoinsListEntity value) {
        if (value.getSymbol() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSymbol());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPrice());
        }
        if (value.getChangePercent() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getChangePercent());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        final int _tmp = value.isFavourite() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getSymbol() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSymbol());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from coins_list";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final List<CoinsListEntity> coinList,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCoinsListEntity.insert(coinList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateCoinsListEntity(final CoinsListEntity data,
      final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfCoinsListEntity.handle(data);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getCoinInfoList(final Continuation<? super List<CoinsListEntity>> continuation) {
    final String _sql = "SELECT * FROM coins_list";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CoinsListEntity>>() {
      @Override
      public List<CoinsListEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfChangePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "changePercent");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final List<CoinsListEntity> _result = new ArrayList<CoinsListEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CoinsListEntity _item;
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            final Double _tmpChangePercent;
            if (_cursor.isNull(_cursorIndexOfChangePercent)) {
              _tmpChangePercent = null;
            } else {
              _tmpChangePercent = _cursor.getDouble(_cursorIndexOfChangePercent);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _item = new CoinsListEntity(_tmpSymbol,_tmpId,_tmpName,_tmpPrice,_tmpChangePercent,_tmpImage,_tmpIsFavourite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<CoinsListEntity>> coinsList() {
    final String _sql = "Select * from coins_list";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"coins_list"}, false, new Callable<List<CoinsListEntity>>() {
      @Override
      public List<CoinsListEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfChangePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "changePercent");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final List<CoinsListEntity> _result = new ArrayList<CoinsListEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CoinsListEntity _item;
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            final Double _tmpChangePercent;
            if (_cursor.isNull(_cursorIndexOfChangePercent)) {
              _tmpChangePercent = null;
            } else {
              _tmpChangePercent = _cursor.getDouble(_cursorIndexOfChangePercent);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _item = new CoinsListEntity(_tmpSymbol,_tmpId,_tmpName,_tmpPrice,_tmpChangePercent,_tmpImage,_tmpIsFavourite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object projectFromSymbol(final String symbol,
      final Continuation<? super CoinsListEntity> continuation) {
    final String _sql = "Select * from coins_list where symbol = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (symbol == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, symbol);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CoinsListEntity>() {
      @Override
      public CoinsListEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfChangePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "changePercent");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final CoinsListEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            final Double _tmpChangePercent;
            if (_cursor.isNull(_cursorIndexOfChangePercent)) {
              _tmpChangePercent = null;
            } else {
              _tmpChangePercent = _cursor.getDouble(_cursorIndexOfChangePercent);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _result = new CoinsListEntity(_tmpSymbol,_tmpId,_tmpName,_tmpPrice,_tmpChangePercent,_tmpImage,_tmpIsFavourite);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<CoinsListEntity> projectLiveDataFromSymbol(final String symbol) {
    final String _sql = "Select * from coins_list where symbol = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (symbol == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, symbol);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"coins_list"}, false, new Callable<CoinsListEntity>() {
      @Override
      public CoinsListEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfChangePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "changePercent");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final CoinsListEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            final Double _tmpChangePercent;
            if (_cursor.isNull(_cursorIndexOfChangePercent)) {
              _tmpChangePercent = null;
            } else {
              _tmpChangePercent = _cursor.getDouble(_cursorIndexOfChangePercent);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _result = new CoinsListEntity(_tmpSymbol,_tmpId,_tmpName,_tmpPrice,_tmpChangePercent,_tmpImage,_tmpIsFavourite);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CoinsListEntity>> favouriteCoins() {
    final String _sql = "Select * from coins_list where isFavourite = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"coins_list"}, false, new Callable<List<CoinsListEntity>>() {
      @Override
      public List<CoinsListEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfChangePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "changePercent");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavourite");
          final List<CoinsListEntity> _result = new ArrayList<CoinsListEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CoinsListEntity _item;
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            final Double _tmpChangePercent;
            if (_cursor.isNull(_cursorIndexOfChangePercent)) {
              _tmpChangePercent = null;
            } else {
              _tmpChangePercent = _cursor.getDouble(_cursorIndexOfChangePercent);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _item = new CoinsListEntity(_tmpSymbol,_tmpId,_tmpName,_tmpPrice,_tmpChangePercent,_tmpImage,_tmpIsFavourite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object favouriteSymbols(final Continuation<? super List<String>> continuation) {
    final String _sql = "Select symbol from coins_list where isFavourite = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
