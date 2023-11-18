package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;

public interface ICustomTabsCallback extends IInterface {
  void extraCallback(String paramString, Bundle paramBundle) throws RemoteException;
  
  Bundle extraCallbackWithResult(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onMessageChannelReady(Bundle paramBundle) throws RemoteException;
  
  void onNavigationEvent(int paramInt, Bundle paramBundle) throws RemoteException;
  
  void onPostMessage(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onRelationshipValidationResult(int paramInt, Uri paramUri, boolean paramBoolean, Bundle paramBundle) throws RemoteException;
  
  public static class Default implements ICustomTabsCallback {
    public IBinder asBinder() {
      return null;
    }
    
    public void extraCallback(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public Bundle extraCallbackWithResult(String param1String, Bundle param1Bundle) throws RemoteException {
      return null;
    }
    
    public void onMessageChannelReady(Bundle param1Bundle) throws RemoteException {}
    
    public void onNavigationEvent(int param1Int, Bundle param1Bundle) throws RemoteException {}
    
    public void onPostMessage(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void onRelationshipValidationResult(int param1Int, Uri param1Uri, boolean param1Boolean, Bundle param1Bundle) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements ICustomTabsCallback {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("55");
    
    static final int TRANSACTION_extraCallback = 3;
    
    static final int TRANSACTION_extraCallbackWithResult = 7;
    
    static final int TRANSACTION_onMessageChannelReady = 4;
    
    static final int TRANSACTION_onNavigationEvent = 2;
    
    static final int TRANSACTION_onPostMessage = 5;
    
    static final int TRANSACTION_onRelationshipValidationResult = 6;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("56"));
    }
    
    public static ICustomTabsCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("57"));
      return (iInterface != null && iInterface instanceof ICustomTabsCallback) ? (ICustomTabsCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public static ICustomTabsCallback getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ICustomTabsCallback param1ICustomTabsCallback) {
      if (Proxy.sDefaultImpl == null) {
        if (param1ICustomTabsCallback != null) {
          Proxy.sDefaultImpl = param1ICustomTabsCallback;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException(v416f9e89.xbd520268("58"));
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str = v416f9e89.xbd520268("59");
      if (param1Int1 != 1598968902) {
        Bundle bundle1;
        Bundle bundle3;
        String str1;
        boolean bool = false;
        String str2 = null;
        Bundle bundle4 = null;
        Bundle bundle6 = null;
        Bundle bundle5 = null;
        Bundle bundle7 = null;
        Bundle bundle2 = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 7:
            param1Parcel1.enforceInterface(str);
            str2 = param1Parcel1.readString();
            if (param1Parcel1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            bundle1 = extraCallbackWithResult(str2, bundle2);
            param1Parcel2.writeNoException();
            if (bundle1 != null) {
              param1Parcel2.writeInt(1);
              bundle1.writeToParcel(param1Parcel2, 1);
              return true;
            } 
            param1Parcel2.writeInt(0);
            return true;
          case 6:
            bundle1.enforceInterface(str);
            param1Int1 = bundle1.readInt();
            if (bundle1.readInt() != 0) {
              Uri uri = (Uri)Uri.CREATOR.createFromParcel((Parcel)bundle1);
            } else {
              bundle2 = null;
            } 
            if (bundle1.readInt() != 0)
              bool = true; 
            if (bundle1.readInt() != 0)
              bundle3 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
            onRelationshipValidationResult(param1Int1, (Uri)bundle2, bool, bundle3);
            param1Parcel2.writeNoException();
            return true;
          case 5:
            bundle1.enforceInterface(str);
            str1 = bundle1.readString();
            bundle2 = bundle4;
            if (bundle1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
            onPostMessage(str1, bundle2);
            param1Parcel2.writeNoException();
            return true;
          case 4:
            bundle1.enforceInterface(str);
            bundle2 = bundle6;
            if (bundle1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
            onMessageChannelReady(bundle2);
            param1Parcel2.writeNoException();
            return true;
          case 3:
            bundle1.enforceInterface(str);
            str1 = bundle1.readString();
            bundle2 = bundle5;
            if (bundle1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
            extraCallback(str1, bundle2);
            param1Parcel2.writeNoException();
            return true;
          case 2:
            break;
        } 
        bundle1.enforceInterface(str);
        param1Int1 = bundle1.readInt();
        bundle2 = bundle7;
        if (bundle1.readInt() != 0)
          bundle2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
        onNavigationEvent(param1Int1, bundle2);
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString(str);
      return true;
    }
    
    private static class Proxy implements ICustomTabsCallback {
      public static ICustomTabsCallback sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void extraCallback(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("16"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
            ICustomTabsCallback.Stub.getDefaultImpl().extraCallback(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle extraCallbackWithResult(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("17"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null)
            return ICustomTabsCallback.Stub.getDefaultImpl().extraCallbackWithResult(param2String, param2Bundle); 
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
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("18");
      }
      
      public void onMessageChannelReady(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("19"));
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
            ICustomTabsCallback.Stub.getDefaultImpl().onMessageChannelReady(param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onNavigationEvent(int param2Int, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("20"));
          parcel1.writeInt(param2Int);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
            ICustomTabsCallback.Stub.getDefaultImpl().onNavigationEvent(param2Int, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onPostMessage(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("21"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
            ICustomTabsCallback.Stub.getDefaultImpl().onPostMessage(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onRelationshipValidationResult(int param2Int, Uri param2Uri, boolean param2Boolean, Bundle param2Bundle) throws RemoteException {
        boolean bool;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("22"));
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        if (param2Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        if (param2Bundle != null) {
          parcel1.writeInt(1);
          param2Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
          ICustomTabsCallback.Stub.getDefaultImpl().onRelationshipValidationResult(param2Int, param2Uri, param2Boolean, param2Bundle);
          parcel2.recycle();
          parcel1.recycle();
          return;
        } 
        parcel2.readException();
        parcel2.recycle();
        parcel1.recycle();
      }
    }
  }
  
  private static class Proxy implements ICustomTabsCallback {
    public static ICustomTabsCallback sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void extraCallback(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("16"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(3, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
          ICustomTabsCallback.Stub.getDefaultImpl().extraCallback(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle extraCallbackWithResult(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("17"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null)
          return ICustomTabsCallback.Stub.getDefaultImpl().extraCallbackWithResult(param1String, param1Bundle); 
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
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("18");
    }
    
    public void onMessageChannelReady(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("19"));
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
          ICustomTabsCallback.Stub.getDefaultImpl().onMessageChannelReady(param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onNavigationEvent(int param1Int, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("20"));
        parcel1.writeInt(param1Int);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
          ICustomTabsCallback.Stub.getDefaultImpl().onNavigationEvent(param1Int, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onPostMessage(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("21"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
          ICustomTabsCallback.Stub.getDefaultImpl().onPostMessage(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onRelationshipValidationResult(int param1Int, Uri param1Uri, boolean param1Boolean, Bundle param1Bundle) throws RemoteException {
      boolean bool;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("22"));
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      if (param1Boolean) {
        bool = true;
      } else {
        bool = false;
      } 
      parcel1.writeInt(bool);
      if (param1Bundle != null) {
        parcel1.writeInt(1);
        param1Bundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ICustomTabsCallback.Stub.getDefaultImpl() != null) {
        ICustomTabsCallback.Stub.getDefaultImpl().onRelationshipValidationResult(param1Int, param1Uri, param1Boolean, param1Bundle);
        parcel2.recycle();
        parcel1.recycle();
        return;
      } 
      parcel2.readException();
      parcel2.recycle();
      parcel1.recycle();
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\customtabs\ICustomTabsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */