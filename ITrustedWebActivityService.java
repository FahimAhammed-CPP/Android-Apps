package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;

public interface ITrustedWebActivityService extends IInterface {
  Bundle areNotificationsEnabled(Bundle paramBundle) throws RemoteException;
  
  void cancelNotification(Bundle paramBundle) throws RemoteException;
  
  Bundle extraCommand(String paramString, Bundle paramBundle, IBinder paramIBinder) throws RemoteException;
  
  Bundle getActiveNotifications() throws RemoteException;
  
  Bundle getSmallIconBitmap() throws RemoteException;
  
  int getSmallIconId() throws RemoteException;
  
  Bundle notifyNotificationWithChannel(Bundle paramBundle) throws RemoteException;
  
  public static class Default implements ITrustedWebActivityService {
    public Bundle areNotificationsEnabled(Bundle param1Bundle) throws RemoteException {
      return null;
    }
    
    public IBinder asBinder() {
      return null;
    }
    
    public void cancelNotification(Bundle param1Bundle) throws RemoteException {}
    
    public Bundle extraCommand(String param1String, Bundle param1Bundle, IBinder param1IBinder) throws RemoteException {
      return null;
    }
    
    public Bundle getActiveNotifications() throws RemoteException {
      return null;
    }
    
    public Bundle getSmallIconBitmap() throws RemoteException {
      return null;
    }
    
    public int getSmallIconId() throws RemoteException {
      return 0;
    }
    
    public Bundle notifyNotificationWithChannel(Bundle param1Bundle) throws RemoteException {
      return null;
    }
  }
  
  public static abstract class Stub extends Binder implements ITrustedWebActivityService {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("449");
    
    static final int TRANSACTION_areNotificationsEnabled = 6;
    
    static final int TRANSACTION_cancelNotification = 3;
    
    static final int TRANSACTION_extraCommand = 9;
    
    static final int TRANSACTION_getActiveNotifications = 5;
    
    static final int TRANSACTION_getSmallIconBitmap = 7;
    
    static final int TRANSACTION_getSmallIconId = 4;
    
    static final int TRANSACTION_notifyNotificationWithChannel = 2;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("450"));
    }
    
    public static ITrustedWebActivityService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("451"));
      return (iInterface != null && iInterface instanceof ITrustedWebActivityService) ? (ITrustedWebActivityService)iInterface : new Proxy(param1IBinder);
    }
    
    public static ITrustedWebActivityService getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ITrustedWebActivityService param1ITrustedWebActivityService) {
      if (Proxy.sDefaultImpl == null) {
        if (param1ITrustedWebActivityService != null) {
          Proxy.sDefaultImpl = param1ITrustedWebActivityService;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException(v416f9e89.xbd520268("452"));
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      Bundle bundle4 = null;
      Bundle bundle5 = null;
      Bundle bundle2 = null;
      Bundle bundle3 = null;
      String str2 = v416f9e89.xbd520268("453");
      if (param1Int1 != 9) {
        if (param1Int1 != 1598968902) {
          switch (param1Int1) {
            default:
              return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
            case 7:
              param1Parcel1.enforceInterface(str2);
              bundle1 = getSmallIconBitmap();
              param1Parcel2.writeNoException();
              if (bundle1 != null) {
                param1Parcel2.writeInt(1);
                bundle1.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 6:
              bundle1.enforceInterface(str2);
              bundle2 = bundle3;
              if (bundle1.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
              bundle1 = areNotificationsEnabled(bundle2);
              param1Parcel2.writeNoException();
              if (bundle1 != null) {
                param1Parcel2.writeInt(1);
                bundle1.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 5:
              bundle1.enforceInterface(str2);
              bundle1 = getActiveNotifications();
              param1Parcel2.writeNoException();
              if (bundle1 != null) {
                param1Parcel2.writeInt(1);
                bundle1.writeToParcel(param1Parcel2, 1);
                return true;
              } 
              param1Parcel2.writeInt(0);
              return true;
            case 4:
              bundle1.enforceInterface(str2);
              param1Int1 = getSmallIconId();
              param1Parcel2.writeNoException();
              param1Parcel2.writeInt(param1Int1);
              return true;
            case 3:
              bundle1.enforceInterface(str2);
              bundle2 = bundle4;
              if (bundle1.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
              cancelNotification(bundle2);
              param1Parcel2.writeNoException();
              return true;
            case 2:
              break;
          } 
          bundle1.enforceInterface(str2);
          bundle2 = bundle5;
          if (bundle1.readInt() != 0)
            bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
          bundle1 = notifyNotificationWithChannel(bundle2);
          param1Parcel2.writeNoException();
          if (bundle1 != null) {
            param1Parcel2.writeInt(1);
            bundle1.writeToParcel(param1Parcel2, 1);
            return true;
          } 
          param1Parcel2.writeInt(0);
          return true;
        } 
        param1Parcel2.writeString(str2);
        return true;
      } 
      bundle1.enforceInterface(str2);
      String str1 = bundle1.readString();
      if (bundle1.readInt() != 0)
        bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
      Bundle bundle1 = extraCommand(str1, bundle2, bundle1.readStrongBinder());
      param1Parcel2.writeNoException();
      if (bundle1 != null) {
        param1Parcel2.writeInt(1);
        bundle1.writeToParcel(param1Parcel2, 1);
        return true;
      } 
      param1Parcel2.writeInt(0);
      return true;
    }
    
    private static class Proxy implements ITrustedWebActivityService {
      public static ITrustedWebActivityService sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public Bundle areNotificationsEnabled(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("441"));
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
            param2Bundle = ITrustedWebActivityService.Stub.getDefaultImpl().areNotificationsEnabled(param2Bundle);
            return param2Bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            param2Bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2Bundle = null;
          } 
          return param2Bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void cancelNotification(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("442"));
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
            ITrustedWebActivityService.Stub.getDefaultImpl().cancelNotification(param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle extraCommand(String param2String, Bundle param2Bundle, IBinder param2IBinder) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("443"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeStrongBinder(param2IBinder);
          if (!this.mRemote.transact(9, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null)
            return ITrustedWebActivityService.Stub.getDefaultImpl().extraCommand(param2String, param2Bundle, param2IBinder); 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String = null;
          } 
          return (Bundle)param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle getActiveNotifications() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          Bundle bundle;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("444"));
          if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
            bundle = ITrustedWebActivityService.Stub.getDefaultImpl().getActiveNotifications();
            return bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            bundle = null;
          } 
          return bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("445");
      }
      
      public Bundle getSmallIconBitmap() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          Bundle bundle;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("446"));
          if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
            bundle = ITrustedWebActivityService.Stub.getDefaultImpl().getSmallIconBitmap();
            return bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            bundle = null;
          } 
          return bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int getSmallIconId() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("447"));
          if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null)
            return ITrustedWebActivityService.Stub.getDefaultImpl().getSmallIconId(); 
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle notifyNotificationWithChannel(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("448"));
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
            param2Bundle = ITrustedWebActivityService.Stub.getDefaultImpl().notifyNotificationWithChannel(param2Bundle);
            return param2Bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            param2Bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2Bundle = null;
          } 
          return param2Bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements ITrustedWebActivityService {
    public static ITrustedWebActivityService sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public Bundle areNotificationsEnabled(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("441"));
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
          param1Bundle = ITrustedWebActivityService.Stub.getDefaultImpl().areNotificationsEnabled(param1Bundle);
          return param1Bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          param1Bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1Bundle = null;
        } 
        return param1Bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void cancelNotification(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("442"));
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(3, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
          ITrustedWebActivityService.Stub.getDefaultImpl().cancelNotification(param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle extraCommand(String param1String, Bundle param1Bundle, IBinder param1IBinder) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("443"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeStrongBinder(param1IBinder);
        if (!this.mRemote.transact(9, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null)
          return ITrustedWebActivityService.Stub.getDefaultImpl().extraCommand(param1String, param1Bundle, param1IBinder); 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String = null;
        } 
        return (Bundle)param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle getActiveNotifications() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        Bundle bundle;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("444"));
        if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
          bundle = ITrustedWebActivityService.Stub.getDefaultImpl().getActiveNotifications();
          return bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          bundle = null;
        } 
        return bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("445");
    }
    
    public Bundle getSmallIconBitmap() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        Bundle bundle;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("446"));
        if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
          bundle = ITrustedWebActivityService.Stub.getDefaultImpl().getSmallIconBitmap();
          return bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          bundle = null;
        } 
        return bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int getSmallIconId() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("447"));
        if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null)
          return ITrustedWebActivityService.Stub.getDefaultImpl().getSmallIconId(); 
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle notifyNotificationWithChannel(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("448"));
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ITrustedWebActivityService.Stub.getDefaultImpl() != null) {
          param1Bundle = ITrustedWebActivityService.Stub.getDefaultImpl().notifyNotificationWithChannel(param1Bundle);
          return param1Bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          param1Bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1Bundle = null;
        } 
        return param1Bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\customtabs\trusted\ITrustedWebActivityService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */