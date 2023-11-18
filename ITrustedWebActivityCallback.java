package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;

public interface ITrustedWebActivityCallback extends IInterface {
  void onExtraCallback(String paramString, Bundle paramBundle) throws RemoteException;
  
  public static class Default implements ITrustedWebActivityCallback {
    public IBinder asBinder() {
      return null;
    }
    
    public void onExtraCallback(String param1String, Bundle param1Bundle) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("429");
    
    static final int TRANSACTION_onExtraCallback = 2;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("430"));
    }
    
    public static ITrustedWebActivityCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("431"));
      return (iInterface != null && iInterface instanceof ITrustedWebActivityCallback) ? (ITrustedWebActivityCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public static ITrustedWebActivityCallback getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ITrustedWebActivityCallback param1ITrustedWebActivityCallback) {
      if (Proxy.sDefaultImpl == null) {
        if (param1ITrustedWebActivityCallback != null) {
          Proxy.sDefaultImpl = param1ITrustedWebActivityCallback;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException(v416f9e89.xbd520268("432"));
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str = v416f9e89.xbd520268("433");
      if (param1Int1 != 2) {
        if (param1Int1 != 1598968902)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel2.writeString(str);
        return true;
      } 
      param1Parcel1.enforceInterface(str);
      str = param1Parcel1.readString();
      if (param1Parcel1.readInt() != 0) {
        Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
      } else {
        param1Parcel1 = null;
      } 
      onExtraCallback(str, (Bundle)param1Parcel1);
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static class Proxy implements ITrustedWebActivityCallback {
      public static ITrustedWebActivityCallback sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("403");
      }
      
      public void onExtraCallback(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("404"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ITrustedWebActivityCallback.Stub.getDefaultImpl() != null) {
            ITrustedWebActivityCallback.Stub.getDefaultImpl().onExtraCallback(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements ITrustedWebActivityCallback {
    public static ITrustedWebActivityCallback sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("403");
    }
    
    public void onExtraCallback(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("404"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ITrustedWebActivityCallback.Stub.getDefaultImpl() != null) {
          ITrustedWebActivityCallback.Stub.getDefaultImpl().onExtraCallback(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\customtabs\trusted\ITrustedWebActivityCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */