package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;

public interface IPostMessageService extends IInterface {
  void onMessageChannelReady(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle) throws RemoteException;
  
  void onPostMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle) throws RemoteException;
  
  public static class Default implements IPostMessageService {
    public IBinder asBinder() {
      return null;
    }
    
    public void onMessageChannelReady(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {}
    
    public void onPostMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements IPostMessageService {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("372");
    
    static final int TRANSACTION_onMessageChannelReady = 2;
    
    static final int TRANSACTION_onPostMessage = 3;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("373"));
    }
    
    public static IPostMessageService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("374"));
      return (iInterface != null && iInterface instanceof IPostMessageService) ? (IPostMessageService)iInterface : new Proxy(param1IBinder);
    }
    
    public static IPostMessageService getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IPostMessageService param1IPostMessageService) {
      if (Proxy.sDefaultImpl == null) {
        if (param1IPostMessageService != null) {
          Proxy.sDefaultImpl = param1IPostMessageService;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException(v416f9e89.xbd520268("375"));
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      Bundle bundle1;
      ICustomTabsCallback iCustomTabsCallback2 = null;
      Bundle bundle2 = null;
      String str = v416f9e89.xbd520268("376");
      if (param1Int1 != 2) {
        if (param1Int1 != 3) {
          if (param1Int1 != 1598968902)
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
          param1Parcel2.writeString(str);
          return true;
        } 
        param1Parcel1.enforceInterface(str);
        iCustomTabsCallback2 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
        str = param1Parcel1.readString();
        if (param1Parcel1.readInt() != 0)
          bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        onPostMessage(iCustomTabsCallback2, str, bundle2);
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel1.enforceInterface(str);
      ICustomTabsCallback iCustomTabsCallback3 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
      ICustomTabsCallback iCustomTabsCallback1 = iCustomTabsCallback2;
      if (param1Parcel1.readInt() != 0)
        bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
      onMessageChannelReady(iCustomTabsCallback3, bundle1);
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static class Proxy implements IPostMessageService {
      public static IPostMessageService sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("367");
      }
      
      public void onMessageChannelReady(ICustomTabsCallback param2ICustomTabsCallback, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("368"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IPostMessageService.Stub.getDefaultImpl() != null) {
            IPostMessageService.Stub.getDefaultImpl().onMessageChannelReady(param2ICustomTabsCallback, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onPostMessage(ICustomTabsCallback param2ICustomTabsCallback, String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("369"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IPostMessageService.Stub.getDefaultImpl() != null) {
            IPostMessageService.Stub.getDefaultImpl().onPostMessage(param2ICustomTabsCallback, param2String, param2Bundle);
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
  
  private static class Proxy implements IPostMessageService {
    public static IPostMessageService sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("367");
    }
    
    public void onMessageChannelReady(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("368"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IPostMessageService.Stub.getDefaultImpl() != null) {
          IPostMessageService.Stub.getDefaultImpl().onMessageChannelReady(param1ICustomTabsCallback, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onPostMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("369"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IPostMessageService.Stub.getDefaultImpl() != null) {
          IPostMessageService.Stub.getDefaultImpl().onPostMessage(param1ICustomTabsCallback, param1String, param1Bundle);
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


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\customtabs\IPostMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */