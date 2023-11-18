package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import h8800e55c.pc41fcc5f.v416f9e89;
import java.util.List;

public interface ICustomTabsService extends IInterface {
  Bundle extraCommand(String paramString, Bundle paramBundle) throws RemoteException;
  
  boolean mayLaunchUrl(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri, Bundle paramBundle, List<Bundle> paramList) throws RemoteException;
  
  boolean newSession(ICustomTabsCallback paramICustomTabsCallback) throws RemoteException;
  
  boolean newSessionWithExtras(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle) throws RemoteException;
  
  int postMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle) throws RemoteException;
  
  boolean receiveFile(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri, int paramInt, Bundle paramBundle) throws RemoteException;
  
  boolean requestPostMessageChannel(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri) throws RemoteException;
  
  boolean requestPostMessageChannelWithExtras(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri, Bundle paramBundle) throws RemoteException;
  
  boolean updateVisuals(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle) throws RemoteException;
  
  boolean validateRelationship(ICustomTabsCallback paramICustomTabsCallback, int paramInt, Uri paramUri, Bundle paramBundle) throws RemoteException;
  
  boolean warmup(long paramLong) throws RemoteException;
  
  public static class Default implements ICustomTabsService {
    public IBinder asBinder() {
      return null;
    }
    
    public Bundle extraCommand(String param1String, Bundle param1Bundle) throws RemoteException {
      return null;
    }
    
    public boolean mayLaunchUrl(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle, List<Bundle> param1List) throws RemoteException {
      return false;
    }
    
    public boolean newSession(ICustomTabsCallback param1ICustomTabsCallback) throws RemoteException {
      return false;
    }
    
    public boolean newSessionWithExtras(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      return false;
    }
    
    public int postMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
      return 0;
    }
    
    public boolean receiveFile(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, int param1Int, Bundle param1Bundle) throws RemoteException {
      return false;
    }
    
    public boolean requestPostMessageChannel(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri) throws RemoteException {
      return false;
    }
    
    public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      return false;
    }
    
    public boolean updateVisuals(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      return false;
    }
    
    public boolean validateRelationship(ICustomTabsCallback param1ICustomTabsCallback, int param1Int, Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      return false;
    }
    
    public boolean warmup(long param1Long) throws RemoteException {
      return false;
    }
  }
  
  public static abstract class Stub extends Binder implements ICustomTabsService {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("248");
    
    static final int TRANSACTION_extraCommand = 5;
    
    static final int TRANSACTION_mayLaunchUrl = 4;
    
    static final int TRANSACTION_newSession = 3;
    
    static final int TRANSACTION_newSessionWithExtras = 10;
    
    static final int TRANSACTION_postMessage = 8;
    
    static final int TRANSACTION_receiveFile = 12;
    
    static final int TRANSACTION_requestPostMessageChannel = 7;
    
    static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
    
    static final int TRANSACTION_updateVisuals = 6;
    
    static final int TRANSACTION_validateRelationship = 9;
    
    static final int TRANSACTION_warmup = 2;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("249"));
    }
    
    public static ICustomTabsService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("250"));
      return (iInterface != null && iInterface instanceof ICustomTabsService) ? (ICustomTabsService)iInterface : new Proxy(param1IBinder);
    }
    
    public static ICustomTabsService getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ICustomTabsService param1ICustomTabsService) {
      if (Proxy.sDefaultImpl == null) {
        if (param1ICustomTabsService != null) {
          Proxy.sDefaultImpl = param1ICustomTabsService;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException(v416f9e89.xbd520268("251"));
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    private static class Proxy implements ICustomTabsService {
      public static ICustomTabsService sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public Bundle extraCommand(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("150"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null)
            return ICustomTabsService.Stub.getDefaultImpl().extraCommand(param2String, param2Bundle); 
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
        return v416f9e89.xbd520268("151");
      }
      
      public boolean mayLaunchUrl(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri, Bundle param2Bundle, List<Bundle> param2List) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("152"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeTypedList(param2List);
          if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().mayLaunchUrl(param2ICustomTabsCallback, param2Uri, param2Bundle, param2List);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean newSession(ICustomTabsCallback param2ICustomTabsCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("153"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          if (!iBinder.transact(3, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().newSession(param2ICustomTabsCallback);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean newSessionWithExtras(ICustomTabsCallback param2ICustomTabsCallback, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("154"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(10, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().newSessionWithExtras(param2ICustomTabsCallback, param2Bundle);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int postMessage(ICustomTabsCallback param2ICustomTabsCallback, String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("155"));
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
          if (!this.mRemote.transact(8, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null)
            return ICustomTabsService.Stub.getDefaultImpl().postMessage(param2ICustomTabsCallback, param2String, param2Bundle); 
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean receiveFile(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri, int param2Int, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("156"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeInt(param2Int);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(12, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().receiveFile(param2ICustomTabsCallback, param2Uri, param2Int, param2Bundle);
            return bool;
          } 
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean requestPostMessageChannel(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("157"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().requestPostMessageChannel(param2ICustomTabsCallback, param2Uri);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("158"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(11, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().requestPostMessageChannelWithExtras(param2ICustomTabsCallback, param2Uri, param2Bundle);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean updateVisuals(ICustomTabsCallback param2ICustomTabsCallback, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("159"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          boolean bool = true;
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().updateVisuals(param2ICustomTabsCallback, param2Bundle);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean validateRelationship(ICustomTabsCallback param2ICustomTabsCallback, int param2Int, Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("160"));
          if (param2ICustomTabsCallback != null) {
            iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          parcel1.writeInt(param2Int);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(9, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().validateRelationship(param2ICustomTabsCallback, param2Int, param2Uri, param2Bundle);
            return bool;
          } 
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean warmup(long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("161"));
          parcel1.writeLong(param2Long);
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          if (!iBinder.transact(2, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
            bool = ICustomTabsService.Stub.getDefaultImpl().warmup(param2Long);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements ICustomTabsService {
    public static ICustomTabsService sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public Bundle extraCommand(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("150"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(5, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null)
          return ICustomTabsService.Stub.getDefaultImpl().extraCommand(param1String, param1Bundle); 
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
      return v416f9e89.xbd520268("151");
    }
    
    public boolean mayLaunchUrl(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle, List<Bundle> param1List) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("152"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeTypedList(param1List);
        if (!this.mRemote.transact(4, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().mayLaunchUrl(param1ICustomTabsCallback, param1Uri, param1Bundle, param1List);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean newSession(ICustomTabsCallback param1ICustomTabsCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("153"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        if (!iBinder.transact(3, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().newSession(param1ICustomTabsCallback);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean newSessionWithExtras(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("154"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(10, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().newSessionWithExtras(param1ICustomTabsCallback, param1Bundle);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int postMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("155"));
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
        if (!this.mRemote.transact(8, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null)
          return ICustomTabsService.Stub.getDefaultImpl().postMessage(param1ICustomTabsCallback, param1String, param1Bundle); 
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean receiveFile(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, int param1Int, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("156"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeInt(param1Int);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(12, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().receiveFile(param1ICustomTabsCallback, param1Uri, param1Int, param1Bundle);
          return bool;
        } 
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean requestPostMessageChannel(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("157"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(7, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().requestPostMessageChannel(param1ICustomTabsCallback, param1Uri);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("158"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(11, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().requestPostMessageChannelWithExtras(param1ICustomTabsCallback, param1Uri, param1Bundle);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean updateVisuals(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("159"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        boolean bool = true;
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(6, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().updateVisuals(param1ICustomTabsCallback, param1Bundle);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean validateRelationship(ICustomTabsCallback param1ICustomTabsCallback, int param1Int, Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("160"));
        if (param1ICustomTabsCallback != null) {
          iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        parcel1.writeInt(param1Int);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(9, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().validateRelationship(param1ICustomTabsCallback, param1Int, param1Uri, param1Bundle);
          return bool;
        } 
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean warmup(long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("161"));
        parcel1.writeLong(param1Long);
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        if (!iBinder.transact(2, parcel1, parcel2, 0) && ICustomTabsService.Stub.getDefaultImpl() != null) {
          bool = ICustomTabsService.Stub.getDefaultImpl().warmup(param1Long);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\customtabs\ICustomTabsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */