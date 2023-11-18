package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import h8800e55c.pc41fcc5f.v416f9e89;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
  void onCaptioningEnabledChanged(boolean paramBoolean) throws RemoteException;
  
  void onEvent(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onExtrasChanged(Bundle paramBundle) throws RemoteException;
  
  void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) throws RemoteException;
  
  void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) throws RemoteException;
  
  void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList) throws RemoteException;
  
  void onQueueTitleChanged(CharSequence paramCharSequence) throws RemoteException;
  
  void onRepeatModeChanged(int paramInt) throws RemoteException;
  
  void onSessionDestroyed() throws RemoteException;
  
  void onSessionReady() throws RemoteException;
  
  void onShuffleModeChanged(int paramInt) throws RemoteException;
  
  void onShuffleModeChangedRemoved(boolean paramBoolean) throws RemoteException;
  
  void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo) throws RemoteException;
  
  public static class Default implements IMediaControllerCallback {
    public IBinder asBinder() {
      return null;
    }
    
    public void onCaptioningEnabledChanged(boolean param1Boolean) throws RemoteException {}
    
    public void onEvent(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void onExtrasChanged(Bundle param1Bundle) throws RemoteException {}
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) throws RemoteException {}
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) throws RemoteException {}
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) throws RemoteException {}
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) throws RemoteException {}
    
    public void onRepeatModeChanged(int param1Int) throws RemoteException {}
    
    public void onSessionDestroyed() throws RemoteException {}
    
    public void onSessionReady() throws RemoteException {}
    
    public void onShuffleModeChanged(int param1Int) throws RemoteException {}
    
    public void onShuffleModeChangedRemoved(boolean param1Boolean) throws RemoteException {}
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements IMediaControllerCallback {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("765");
    
    static final int TRANSACTION_onCaptioningEnabledChanged = 11;
    
    static final int TRANSACTION_onEvent = 1;
    
    static final int TRANSACTION_onExtrasChanged = 7;
    
    static final int TRANSACTION_onMetadataChanged = 4;
    
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    
    static final int TRANSACTION_onQueueChanged = 5;
    
    static final int TRANSACTION_onQueueTitleChanged = 6;
    
    static final int TRANSACTION_onRepeatModeChanged = 9;
    
    static final int TRANSACTION_onSessionDestroyed = 2;
    
    static final int TRANSACTION_onSessionReady = 13;
    
    static final int TRANSACTION_onShuffleModeChanged = 12;
    
    static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
    
    static final int TRANSACTION_onVolumeInfoChanged = 8;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("766"));
    }
    
    public static IMediaControllerCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("767"));
      return (iInterface != null && iInterface instanceof IMediaControllerCallback) ? (IMediaControllerCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public static IMediaControllerCallback getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IMediaControllerCallback param1IMediaControllerCallback) {
      if (Proxy.sDefaultImpl == null && param1IMediaControllerCallback != null) {
        Proxy.sDefaultImpl = param1IMediaControllerCallback;
        return true;
      } 
      return false;
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      Bundle bundle;
      String str = v416f9e89.xbd520268("768");
      if (param1Int1 != 1598968902) {
        ParcelableVolumeInfo parcelableVolumeInfo1;
        Bundle bundle1;
        CharSequence charSequence1;
        MediaMetadataCompat mediaMetadataCompat1;
        boolean bool2 = false;
        boolean bool1 = false;
        ParcelableVolumeInfo parcelableVolumeInfo2 = null;
        Bundle bundle2 = null;
        CharSequence charSequence2 = null;
        MediaMetadataCompat mediaMetadataCompat2 = null;
        PlaybackStateCompat playbackStateCompat2 = null;
        Parcel parcel = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 13:
            param1Parcel1.enforceInterface(str);
            onSessionReady();
            return true;
          case 12:
            param1Parcel1.enforceInterface(str);
            onShuffleModeChanged(param1Parcel1.readInt());
            return true;
          case 11:
            param1Parcel1.enforceInterface(str);
            if (param1Parcel1.readInt() != 0)
              bool1 = true; 
            onCaptioningEnabledChanged(bool1);
            return true;
          case 10:
            param1Parcel1.enforceInterface(str);
            bool1 = bool2;
            if (param1Parcel1.readInt() != 0)
              bool1 = true; 
            onShuffleModeChangedRemoved(bool1);
            return true;
          case 9:
            param1Parcel1.enforceInterface(str);
            onRepeatModeChanged(param1Parcel1.readInt());
            return true;
          case 8:
            param1Parcel1.enforceInterface(str);
            param1Parcel2 = parcel;
            if (param1Parcel1.readInt() != 0)
              parcelableVolumeInfo1 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(param1Parcel1); 
            onVolumeInfoChanged(parcelableVolumeInfo1);
            return true;
          case 7:
            param1Parcel1.enforceInterface(str);
            parcelableVolumeInfo1 = parcelableVolumeInfo2;
            if (param1Parcel1.readInt() != 0)
              bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            onExtrasChanged(bundle1);
            return true;
          case 6:
            param1Parcel1.enforceInterface(str);
            bundle1 = bundle2;
            if (param1Parcel1.readInt() != 0)
              charSequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel1); 
            onQueueTitleChanged(charSequence1);
            return true;
          case 5:
            param1Parcel1.enforceInterface(str);
            onQueueChanged(param1Parcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
          case 4:
            param1Parcel1.enforceInterface(str);
            charSequence1 = charSequence2;
            if (param1Parcel1.readInt() != 0)
              mediaMetadataCompat1 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(param1Parcel1); 
            onMetadataChanged(mediaMetadataCompat1);
            return true;
          case 3:
            param1Parcel1.enforceInterface(str);
            mediaMetadataCompat1 = mediaMetadataCompat2;
            if (param1Parcel1.readInt() != 0)
              playbackStateCompat1 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(param1Parcel1); 
            onPlaybackStateChanged(playbackStateCompat1);
            return true;
          case 2:
            param1Parcel1.enforceInterface(str);
            onSessionDestroyed();
            return true;
          case 1:
            break;
        } 
        param1Parcel1.enforceInterface(str);
        String str1 = param1Parcel1.readString();
        PlaybackStateCompat playbackStateCompat1 = playbackStateCompat2;
        if (param1Parcel1.readInt() != 0)
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        onEvent(str1, bundle);
        return true;
      } 
      bundle.writeString(str);
      return true;
    }
    
    private static class Proxy implements IMediaControllerCallback {
      public static IMediaControllerCallback sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("740");
      }
      
      public void onCaptioningEnabledChanged(boolean param2Boolean) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          boolean bool;
          parcel.writeInterfaceToken(v416f9e89.xbd520268("741"));
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel.writeInt(bool);
          if (!this.mRemote.transact(11, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onCaptioningEnabledChanged(param2Boolean);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onEvent(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("742"));
          parcel.writeString(param2String);
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(1, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onEvent(param2String, param2Bundle);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onExtrasChanged(Bundle param2Bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("743"));
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(7, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onExtrasChanged(param2Bundle);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onMetadataChanged(MediaMetadataCompat param2MediaMetadataCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("744"));
          if (param2MediaMetadataCompat != null) {
            parcel.writeInt(1);
            param2MediaMetadataCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(4, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onMetadataChanged(param2MediaMetadataCompat);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat param2PlaybackStateCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("745"));
          if (param2PlaybackStateCompat != null) {
            parcel.writeInt(1);
            param2PlaybackStateCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(3, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onPlaybackStateChanged(param2PlaybackStateCompat);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> param2List) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("746"));
          parcel.writeTypedList(param2List);
          if (!this.mRemote.transact(5, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onQueueChanged(param2List);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("747"));
          if (param2CharSequence != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(param2CharSequence, parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(6, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onQueueTitleChanged(param2CharSequence);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onRepeatModeChanged(int param2Int) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("748"));
          parcel.writeInt(param2Int);
          if (!this.mRemote.transact(9, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onRepeatModeChanged(param2Int);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onSessionDestroyed() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("749"));
          if (!this.mRemote.transact(2, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onSessionDestroyed();
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onSessionReady() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("750"));
          if (!this.mRemote.transact(13, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onSessionReady();
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onShuffleModeChanged(int param2Int) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("751"));
          parcel.writeInt(param2Int);
          if (!this.mRemote.transact(12, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChanged(param2Int);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onShuffleModeChangedRemoved(boolean param2Boolean) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          boolean bool;
          parcel.writeInterfaceToken(v416f9e89.xbd520268("752"));
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel.writeInt(bool);
          if (!this.mRemote.transact(10, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChangedRemoved(param2Boolean);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo param2ParcelableVolumeInfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken(v416f9e89.xbd520268("753"));
          if (param2ParcelableVolumeInfo != null) {
            parcel.writeInt(1);
            param2ParcelableVolumeInfo.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (!this.mRemote.transact(8, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
            IMediaControllerCallback.Stub.getDefaultImpl().onVolumeInfoChanged(param2ParcelableVolumeInfo);
            return;
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IMediaControllerCallback {
    public static IMediaControllerCallback sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("740");
    }
    
    public void onCaptioningEnabledChanged(boolean param1Boolean) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        boolean bool;
        parcel.writeInterfaceToken(v416f9e89.xbd520268("741"));
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel.writeInt(bool);
        if (!this.mRemote.transact(11, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onCaptioningEnabledChanged(param1Boolean);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onEvent(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("742"));
        parcel.writeString(param1String);
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(1, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onEvent(param1String, param1Bundle);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onExtrasChanged(Bundle param1Bundle) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("743"));
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(7, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onExtrasChanged(param1Bundle);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("744"));
        if (param1MediaMetadataCompat != null) {
          parcel.writeInt(1);
          param1MediaMetadataCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(4, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onMetadataChanged(param1MediaMetadataCompat);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("745"));
        if (param1PlaybackStateCompat != null) {
          parcel.writeInt(1);
          param1PlaybackStateCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(3, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onPlaybackStateChanged(param1PlaybackStateCompat);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("746"));
        parcel.writeTypedList(param1List);
        if (!this.mRemote.transact(5, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onQueueChanged(param1List);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("747"));
        if (param1CharSequence != null) {
          parcel.writeInt(1);
          TextUtils.writeToParcel(param1CharSequence, parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(6, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onQueueTitleChanged(param1CharSequence);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onRepeatModeChanged(int param1Int) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("748"));
        parcel.writeInt(param1Int);
        if (!this.mRemote.transact(9, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onRepeatModeChanged(param1Int);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onSessionDestroyed() throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("749"));
        if (!this.mRemote.transact(2, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onSessionDestroyed();
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onSessionReady() throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("750"));
        if (!this.mRemote.transact(13, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onSessionReady();
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onShuffleModeChanged(int param1Int) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("751"));
        parcel.writeInt(param1Int);
        if (!this.mRemote.transact(12, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChanged(param1Int);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onShuffleModeChangedRemoved(boolean param1Boolean) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        boolean bool;
        parcel.writeInterfaceToken(v416f9e89.xbd520268("752"));
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel.writeInt(bool);
        if (!this.mRemote.transact(10, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChangedRemoved(param1Boolean);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken(v416f9e89.xbd520268("753"));
        if (param1ParcelableVolumeInfo != null) {
          parcel.writeInt(1);
          param1ParcelableVolumeInfo.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (!this.mRemote.transact(8, parcel, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
          IMediaControllerCallback.Stub.getDefaultImpl().onVolumeInfoChanged(param1ParcelableVolumeInfo);
          return;
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */