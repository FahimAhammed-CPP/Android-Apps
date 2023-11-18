package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;

public interface INotificationSideChannel extends IInterface {
  public static final String DESCRIPTOR = v416f9e89.xbd520268("501").replace('$', '.');
  
  void cancel(String paramString1, int paramInt, String paramString2) throws RemoteException;
  
  void cancelAll(String paramString) throws RemoteException;
  
  void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification) throws RemoteException;
  
  public static class Default implements INotificationSideChannel {
    public IBinder asBinder() {
      return null;
    }
    
    public void cancel(String param1String1, int param1Int, String param1String2) throws RemoteException {}
    
    public void cancelAll(String param1String) throws RemoteException {}
    
    public void notify(String param1String1, int param1Int, String param1String2, Notification param1Notification) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements INotificationSideChannel {
    static final int TRANSACTION_cancel = 2;
    
    static final int TRANSACTION_cancelAll = 3;
    
    static final int TRANSACTION_notify = 1;
    
    public Stub() {
      attachInterface(this, DESCRIPTOR);
    }
    
    public static INotificationSideChannel asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(DESCRIPTOR);
      return (iInterface != null && iInterface instanceof INotificationSideChannel) ? (INotificationSideChannel)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str = DESCRIPTOR;
      if (param1Int1 >= 1 && param1Int1 <= 16777215)
        param1Parcel1.enforceInterface(str); 
      if (param1Int1 != 1598968902) {
        if (param1Int1 != 1) {
          if (param1Int1 != 2) {
            if (param1Int1 != 3)
              return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
            cancelAll(param1Parcel1.readString());
            return true;
          } 
          cancel(param1Parcel1.readString(), param1Parcel1.readInt(), param1Parcel1.readString());
          return true;
        } 
        notify(param1Parcel1.readString(), param1Parcel1.readInt(), param1Parcel1.readString(), (Notification)INotificationSideChannel._Parcel.readTypedObject(param1Parcel1, Notification.CREATOR));
        return true;
      } 
      param1Parcel2.writeString(str);
      return true;
    }
    
    private static class Proxy implements INotificationSideChannel {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void cancel(String param2String1, int param2Int, String param2String2) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(DESCRIPTOR);
          parcel.writeString(param2String1);
          parcel.writeInt(param2Int);
          parcel.writeString(param2String2);
          this.mRemote.transact(2, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void cancelAll(String param2String) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(DESCRIPTOR);
          parcel.writeString(param2String);
          this.mRemote.transact(3, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return DESCRIPTOR;
      }
      
      public void notify(String param2String1, int param2Int, String param2String2, Notification param2Notification) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(DESCRIPTOR);
          parcel.writeString(param2String1);
          parcel.writeInt(param2Int);
          parcel.writeString(param2String2);
          INotificationSideChannel._Parcel.writeTypedObject(parcel, (T)param2Notification, 0);
          this.mRemote.transact(1, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements INotificationSideChannel {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void cancel(String param1String1, int param1Int, String param1String2) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(DESCRIPTOR);
        parcel.writeString(param1String1);
        parcel.writeInt(param1Int);
        parcel.writeString(param1String2);
        this.mRemote.transact(2, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void cancelAll(String param1String) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(DESCRIPTOR);
        parcel.writeString(param1String);
        this.mRemote.transact(3, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return DESCRIPTOR;
    }
    
    public void notify(String param1String1, int param1Int, String param1String2, Notification param1Notification) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(DESCRIPTOR);
        parcel.writeString(param1String1);
        parcel.writeInt(param1Int);
        parcel.writeString(param1String2);
        INotificationSideChannel._Parcel.writeTypedObject(parcel, (T)param1Notification, 0);
        this.mRemote.transact(1, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
  
  public static class _Parcel {
    private static <T> T readTypedObject(Parcel param1Parcel, Parcelable.Creator<T> param1Creator) {
      return (T)((param1Parcel.readInt() != 0) ? param1Creator.createFromParcel(param1Parcel) : null);
    }
    
    private static <T extends Parcelable> void writeTypedObject(Parcel param1Parcel, T param1T, int param1Int) {
      if (param1T != null) {
        param1Parcel.writeInt(1);
        param1T.writeToParcel(param1Parcel, param1Int);
        return;
      } 
      param1Parcel.writeInt(0);
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\v4\app\INotificationSideChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */