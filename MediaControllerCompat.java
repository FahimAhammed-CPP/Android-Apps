package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.R;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import h8800e55c.pc41fcc5f.v416f9e89;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaControllerCompat {
  public static final String COMMAND_ADD_QUEUE_ITEM = v416f9e89.xbd520268("217");
  
  public static final String COMMAND_ADD_QUEUE_ITEM_AT = v416f9e89.xbd520268("218");
  
  public static final String COMMAND_ARGUMENT_INDEX = v416f9e89.xbd520268("219");
  
  public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = v416f9e89.xbd520268("220");
  
  public static final String COMMAND_GET_EXTRA_BINDER = v416f9e89.xbd520268("221");
  
  public static final String COMMAND_REMOVE_QUEUE_ITEM = v416f9e89.xbd520268("222");
  
  public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = v416f9e89.xbd520268("223");
  
  static final String TAG = v416f9e89.xbd520268("224");
  
  private final MediaControllerImpl mImpl;
  
  private final ConcurrentHashMap<Callback, Boolean> mRegisteredCallbacks = new ConcurrentHashMap<Callback, Boolean>();
  
  private final MediaSessionCompat.Token mToken;
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken) {
    if (paramToken != null) {
      this.mToken = paramToken;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mImpl = new MediaControllerImplApi21(paramContext, paramToken);
        return;
      } 
      this.mImpl = new MediaControllerImplBase(paramToken);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("225"));
  }
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat paramMediaSessionCompat) {
    if (paramMediaSessionCompat != null) {
      MediaSessionCompat.Token token = paramMediaSessionCompat.getSessionToken();
      this.mToken = token;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mImpl = new MediaControllerImplApi21(paramContext, token);
        return;
      } 
      this.mImpl = new MediaControllerImplBase(token);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("226"));
  }
  
  public static MediaControllerCompat getMediaController(Activity paramActivity) {
    Object object = paramActivity.getWindow().getDecorView().getTag(R.id.media_controller_compat_view_tag);
    if (object instanceof MediaControllerCompat)
      return (MediaControllerCompat)object; 
    if (Build.VERSION.SDK_INT >= 21) {
      object = paramActivity.getMediaController();
      return (object == null) ? null : new MediaControllerCompat((Context)paramActivity, MediaSessionCompat.Token.fromToken(object.getSessionToken()));
    } 
    return null;
  }
  
  public static void setMediaController(Activity paramActivity, MediaControllerCompat paramMediaControllerCompat) {
    paramActivity.getWindow().getDecorView().setTag(R.id.media_controller_compat_view_tag, paramMediaControllerCompat);
    if (Build.VERSION.SDK_INT >= 21) {
      MediaController mediaController = null;
      if (paramMediaControllerCompat != null)
        mediaController = new MediaController((Context)paramActivity, (MediaSession.Token)paramMediaControllerCompat.getSessionToken().getToken()); 
      paramActivity.setMediaController(mediaController);
    } 
  }
  
  static void validateCustomAction(String paramString, Bundle paramBundle) {
    if (paramString == null)
      return; 
    paramString.hashCode();
    if (!paramString.equals(v416f9e89.xbd520268("227")) && !paramString.equals(v416f9e89.xbd520268("228")))
      return; 
    if (paramBundle != null && paramBundle.containsKey(v416f9e89.xbd520268("229")))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(v416f9e89.xbd520268("230"));
    stringBuilder.append(paramString);
    stringBuilder.append(v416f9e89.xbd520268("231"));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) {
    this.mImpl.addQueueItem(paramMediaDescriptionCompat);
  }
  
  public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt) {
    this.mImpl.addQueueItem(paramMediaDescriptionCompat, paramInt);
  }
  
  public void adjustVolume(int paramInt1, int paramInt2) {
    this.mImpl.adjustVolume(paramInt1, paramInt2);
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent != null)
      return this.mImpl.dispatchMediaButtonEvent(paramKeyEvent); 
    throw new IllegalArgumentException(v416f9e89.xbd520268("232"));
  }
  
  public Bundle getExtras() {
    return this.mImpl.getExtras();
  }
  
  public long getFlags() {
    return this.mImpl.getFlags();
  }
  
  public Object getMediaController() {
    return this.mImpl.getMediaController();
  }
  
  public MediaMetadataCompat getMetadata() {
    return this.mImpl.getMetadata();
  }
  
  public String getPackageName() {
    return this.mImpl.getPackageName();
  }
  
  public PlaybackInfo getPlaybackInfo() {
    return this.mImpl.getPlaybackInfo();
  }
  
  public PlaybackStateCompat getPlaybackState() {
    return this.mImpl.getPlaybackState();
  }
  
  public List<MediaSessionCompat.QueueItem> getQueue() {
    return this.mImpl.getQueue();
  }
  
  public CharSequence getQueueTitle() {
    return this.mImpl.getQueueTitle();
  }
  
  public int getRatingType() {
    return this.mImpl.getRatingType();
  }
  
  public int getRepeatMode() {
    return this.mImpl.getRepeatMode();
  }
  
  public VersionedParcelable getSession2Token() {
    return this.mToken.getSession2Token();
  }
  
  public PendingIntent getSessionActivity() {
    return this.mImpl.getSessionActivity();
  }
  
  public Bundle getSessionInfo() {
    return this.mImpl.getSessionInfo();
  }
  
  public MediaSessionCompat.Token getSessionToken() {
    return this.mToken;
  }
  
  public int getShuffleMode() {
    return this.mImpl.getShuffleMode();
  }
  
  public TransportControls getTransportControls() {
    return this.mImpl.getTransportControls();
  }
  
  public boolean isCaptioningEnabled() {
    return this.mImpl.isCaptioningEnabled();
  }
  
  public boolean isSessionReady() {
    return this.mImpl.isSessionReady();
  }
  
  public void registerCallback(Callback paramCallback) {
    registerCallback(paramCallback, null);
  }
  
  public void registerCallback(Callback paramCallback, Handler paramHandler) {
    if (paramCallback != null) {
      if (this.mRegisteredCallbacks.putIfAbsent(paramCallback, Boolean.valueOf(true)) != null) {
        Log.w(v416f9e89.xbd520268("233"), v416f9e89.xbd520268("234"));
        return;
      } 
      Handler handler = paramHandler;
      if (paramHandler == null)
        handler = new Handler(); 
      paramCallback.setHandler(handler);
      this.mImpl.registerCallback(paramCallback, handler);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("235"));
  }
  
  public void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) {
    this.mImpl.removeQueueItem(paramMediaDescriptionCompat);
  }
  
  @Deprecated
  public void removeQueueItemAt(int paramInt) {
    List<MediaSessionCompat.QueueItem> list = getQueue();
    if (list != null && paramInt >= 0 && paramInt < list.size()) {
      MediaSessionCompat.QueueItem queueItem = list.get(paramInt);
      if (queueItem != null)
        removeQueueItem(queueItem.getDescription()); 
    } 
  }
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver) {
    if (!TextUtils.isEmpty(paramString)) {
      this.mImpl.sendCommand(paramString, paramBundle, paramResultReceiver);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("236"));
  }
  
  public void setVolumeTo(int paramInt1, int paramInt2) {
    this.mImpl.setVolumeTo(paramInt1, paramInt2);
  }
  
  public void unregisterCallback(Callback paramCallback) {
    if (paramCallback != null) {
      if (this.mRegisteredCallbacks.remove(paramCallback) == null) {
        Log.w(v416f9e89.xbd520268("237"), v416f9e89.xbd520268("238"));
        return;
      } 
      try {
        this.mImpl.unregisterCallback(paramCallback);
        return;
      } finally {
        paramCallback.setHandler(null);
      } 
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("239"));
  }
  
  public static abstract class Callback implements IBinder.DeathRecipient {
    final MediaController.Callback mCallbackFwk;
    
    MessageHandler mHandler;
    
    IMediaControllerCallback mIControllerCallback;
    
    public Callback() {
      if (Build.VERSION.SDK_INT >= 21) {
        this.mCallbackFwk = new MediaControllerCallbackApi21(this);
        return;
      } 
      this.mCallbackFwk = null;
      this.mIControllerCallback = new StubCompat(this);
    }
    
    public void binderDied() {
      postToHandler(8, null, null);
    }
    
    public IMediaControllerCallback getIControllerCallback() {
      return this.mIControllerCallback;
    }
    
    public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo param1PlaybackInfo) {}
    
    public void onCaptioningEnabledChanged(boolean param1Boolean) {}
    
    public void onExtrasChanged(Bundle param1Bundle) {}
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) {}
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) {}
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) {}
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) {}
    
    public void onRepeatModeChanged(int param1Int) {}
    
    public void onSessionDestroyed() {}
    
    public void onSessionEvent(String param1String, Bundle param1Bundle) {}
    
    public void onSessionReady() {}
    
    public void onShuffleModeChanged(int param1Int) {}
    
    void postToHandler(int param1Int, Object param1Object, Bundle param1Bundle) {
      MessageHandler messageHandler = this.mHandler;
      if (messageHandler != null) {
        param1Object = messageHandler.obtainMessage(param1Int, param1Object);
        param1Object.setData(param1Bundle);
        param1Object.sendToTarget();
      } 
    }
    
    void setHandler(Handler param1Handler) {
      if (param1Handler == null) {
        param1Handler = this.mHandler;
        if (param1Handler != null) {
          ((MessageHandler)param1Handler).mRegistered = false;
          this.mHandler.removeCallbacksAndMessages(null);
          this.mHandler = null;
          return;
        } 
      } else {
        param1Handler = new MessageHandler(param1Handler.getLooper());
        this.mHandler = (MessageHandler)param1Handler;
        ((MessageHandler)param1Handler).mRegistered = true;
      } 
    }
    
    private static class MediaControllerCallbackApi21 extends MediaController.Callback {
      private final WeakReference<MediaControllerCompat.Callback> mCallback;
      
      MediaControllerCallbackApi21(MediaControllerCompat.Callback param2Callback) {
        this.mCallback = new WeakReference<MediaControllerCompat.Callback>(param2Callback);
      }
      
      public void onAudioInfoChanged(MediaController.PlaybackInfo param2PlaybackInfo) {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(param2PlaybackInfo.getPlaybackType(), AudioAttributesCompat.wrap(param2PlaybackInfo.getAudioAttributes()), param2PlaybackInfo.getVolumeControl(), param2PlaybackInfo.getMaxVolume(), param2PlaybackInfo.getCurrentVolume())); 
      }
      
      public void onExtrasChanged(Bundle param2Bundle) {
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onExtrasChanged(param2Bundle); 
      }
      
      public void onMetadataChanged(MediaMetadata param2MediaMetadata) {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(param2MediaMetadata)); 
      }
      
      public void onPlaybackStateChanged(PlaybackState param2PlaybackState) {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
          if (callback.mIControllerCallback != null)
            return; 
          callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(param2PlaybackState));
        } 
      }
      
      public void onQueueChanged(List<MediaSession.QueueItem> param2List) {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(param2List)); 
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onQueueTitleChanged(param2CharSequence); 
      }
      
      public void onSessionDestroyed() {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.onSessionDestroyed(); 
      }
      
      public void onSessionEvent(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
          if (callback.mIControllerCallback != null && Build.VERSION.SDK_INT < 23)
            return; 
          callback.onSessionEvent(param2String, param2Bundle);
        } 
      }
    }
    
    private class MessageHandler extends Handler {
      private static final int MSG_DESTROYED = 8;
      
      private static final int MSG_EVENT = 1;
      
      private static final int MSG_SESSION_READY = 13;
      
      private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
      
      private static final int MSG_UPDATE_EXTRAS = 7;
      
      private static final int MSG_UPDATE_METADATA = 3;
      
      private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
      
      private static final int MSG_UPDATE_QUEUE = 5;
      
      private static final int MSG_UPDATE_QUEUE_TITLE = 6;
      
      private static final int MSG_UPDATE_REPEAT_MODE = 9;
      
      private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
      
      private static final int MSG_UPDATE_VOLUME = 4;
      
      boolean mRegistered = false;
      
      MessageHandler(Looper param2Looper) {
        super(param2Looper);
      }
      
      public void handleMessage(Message param2Message) {
        Bundle bundle1;
        if (!this.mRegistered)
          return; 
        switch (param2Message.what) {
          default:
            return;
          case 13:
            MediaControllerCompat.Callback.this.onSessionReady();
            return;
          case 12:
            MediaControllerCompat.Callback.this.onShuffleModeChanged(((Integer)param2Message.obj).intValue());
            return;
          case 11:
            MediaControllerCompat.Callback.this.onCaptioningEnabledChanged(((Boolean)param2Message.obj).booleanValue());
            return;
          case 9:
            MediaControllerCompat.Callback.this.onRepeatModeChanged(((Integer)param2Message.obj).intValue());
            return;
          case 8:
            MediaControllerCompat.Callback.this.onSessionDestroyed();
            return;
          case 7:
            bundle1 = (Bundle)param2Message.obj;
            MediaSessionCompat.ensureClassLoader(bundle1);
            MediaControllerCompat.Callback.this.onExtrasChanged(bundle1);
            return;
          case 6:
            MediaControllerCompat.Callback.this.onQueueTitleChanged((CharSequence)((Message)bundle1).obj);
            return;
          case 5:
            MediaControllerCompat.Callback.this.onQueueChanged((List<MediaSessionCompat.QueueItem>)((Message)bundle1).obj);
            return;
          case 4:
            MediaControllerCompat.Callback.this.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)((Message)bundle1).obj);
            return;
          case 3:
            MediaControllerCompat.Callback.this.onMetadataChanged((MediaMetadataCompat)((Message)bundle1).obj);
            return;
          case 2:
            MediaControllerCompat.Callback.this.onPlaybackStateChanged((PlaybackStateCompat)((Message)bundle1).obj);
            return;
          case 1:
            break;
        } 
        Bundle bundle2 = bundle1.getData();
        MediaSessionCompat.ensureClassLoader(bundle2);
        MediaControllerCompat.Callback.this.onSessionEvent((String)((Message)bundle1).obj, bundle2);
      }
    }
    
    private static class StubCompat extends IMediaControllerCallback.Stub {
      private final WeakReference<MediaControllerCompat.Callback> mCallback;
      
      StubCompat(MediaControllerCompat.Callback param2Callback) {
        this.mCallback = new WeakReference<MediaControllerCompat.Callback>(param2Callback);
      }
      
      public void onCaptioningEnabledChanged(boolean param2Boolean) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(11, Boolean.valueOf(param2Boolean), null); 
      }
      
      public void onEvent(String param2String, Bundle param2Bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(1, param2String, param2Bundle); 
      }
      
      public void onExtrasChanged(Bundle param2Bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(7, param2Bundle, null); 
      }
      
      public void onMetadataChanged(MediaMetadataCompat param2MediaMetadataCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(3, param2MediaMetadataCompat, null); 
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat param2PlaybackStateCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(2, param2PlaybackStateCompat, null); 
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> param2List) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(5, param2List, null); 
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(6, param2CharSequence, null); 
      }
      
      public void onRepeatModeChanged(int param2Int) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(9, Integer.valueOf(param2Int), null); 
      }
      
      public void onSessionDestroyed() throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(8, null, null); 
      }
      
      public void onSessionReady() throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(13, null, null); 
      }
      
      public void onShuffleModeChanged(int param2Int) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null)
          callback.postToHandler(12, Integer.valueOf(param2Int), null); 
      }
      
      public void onShuffleModeChangedRemoved(boolean param2Boolean) throws RemoteException {}
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo param2ParcelableVolumeInfo) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
          if (param2ParcelableVolumeInfo != null) {
            MediaControllerCompat.PlaybackInfo playbackInfo = new MediaControllerCompat.PlaybackInfo(param2ParcelableVolumeInfo.volumeType, param2ParcelableVolumeInfo.audioStream, param2ParcelableVolumeInfo.controlType, param2ParcelableVolumeInfo.maxVolume, param2ParcelableVolumeInfo.currentVolume);
          } else {
            param2ParcelableVolumeInfo = null;
          } 
          callback.postToHandler(4, param2ParcelableVolumeInfo, null);
        } 
      }
    }
  }
  
  private static class MediaControllerCallbackApi21 extends MediaController.Callback {
    private final WeakReference<MediaControllerCompat.Callback> mCallback;
    
    MediaControllerCallbackApi21(MediaControllerCompat.Callback param1Callback) {
      this.mCallback = new WeakReference<MediaControllerCompat.Callback>(param1Callback);
    }
    
    public void onAudioInfoChanged(MediaController.PlaybackInfo param1PlaybackInfo) {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(param1PlaybackInfo.getPlaybackType(), AudioAttributesCompat.wrap(param1PlaybackInfo.getAudioAttributes()), param1PlaybackInfo.getVolumeControl(), param1PlaybackInfo.getMaxVolume(), param1PlaybackInfo.getCurrentVolume())); 
    }
    
    public void onExtrasChanged(Bundle param1Bundle) {
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onExtrasChanged(param1Bundle); 
    }
    
    public void onMetadataChanged(MediaMetadata param1MediaMetadata) {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(param1MediaMetadata)); 
    }
    
    public void onPlaybackStateChanged(PlaybackState param1PlaybackState) {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null) {
        if (callback.mIControllerCallback != null)
          return; 
        callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(param1PlaybackState));
      } 
    }
    
    public void onQueueChanged(List<MediaSession.QueueItem> param1List) {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(param1List)); 
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onQueueTitleChanged(param1CharSequence); 
    }
    
    public void onSessionDestroyed() {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.onSessionDestroyed(); 
    }
    
    public void onSessionEvent(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null) {
        if (callback.mIControllerCallback != null && Build.VERSION.SDK_INT < 23)
          return; 
        callback.onSessionEvent(param1String, param1Bundle);
      } 
    }
  }
  
  private class MessageHandler extends Handler {
    private static final int MSG_DESTROYED = 8;
    
    private static final int MSG_EVENT = 1;
    
    private static final int MSG_SESSION_READY = 13;
    
    private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
    
    private static final int MSG_UPDATE_EXTRAS = 7;
    
    private static final int MSG_UPDATE_METADATA = 3;
    
    private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
    
    private static final int MSG_UPDATE_QUEUE = 5;
    
    private static final int MSG_UPDATE_QUEUE_TITLE = 6;
    
    private static final int MSG_UPDATE_REPEAT_MODE = 9;
    
    private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
    
    private static final int MSG_UPDATE_VOLUME = 4;
    
    boolean mRegistered = false;
    
    MessageHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      Bundle bundle1;
      if (!this.mRegistered)
        return; 
      switch (param1Message.what) {
        default:
          return;
        case 13:
          this.this$0.onSessionReady();
          return;
        case 12:
          this.this$0.onShuffleModeChanged(((Integer)param1Message.obj).intValue());
          return;
        case 11:
          this.this$0.onCaptioningEnabledChanged(((Boolean)param1Message.obj).booleanValue());
          return;
        case 9:
          this.this$0.onRepeatModeChanged(((Integer)param1Message.obj).intValue());
          return;
        case 8:
          this.this$0.onSessionDestroyed();
          return;
        case 7:
          bundle1 = (Bundle)param1Message.obj;
          MediaSessionCompat.ensureClassLoader(bundle1);
          this.this$0.onExtrasChanged(bundle1);
          return;
        case 6:
          this.this$0.onQueueTitleChanged((CharSequence)((Message)bundle1).obj);
          return;
        case 5:
          this.this$0.onQueueChanged((List<MediaSessionCompat.QueueItem>)((Message)bundle1).obj);
          return;
        case 4:
          this.this$0.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)((Message)bundle1).obj);
          return;
        case 3:
          this.this$0.onMetadataChanged((MediaMetadataCompat)((Message)bundle1).obj);
          return;
        case 2:
          this.this$0.onPlaybackStateChanged((PlaybackStateCompat)((Message)bundle1).obj);
          return;
        case 1:
          break;
      } 
      Bundle bundle2 = bundle1.getData();
      MediaSessionCompat.ensureClassLoader(bundle2);
      this.this$0.onSessionEvent((String)((Message)bundle1).obj, bundle2);
    }
  }
  
  private static class StubCompat extends IMediaControllerCallback.Stub {
    private final WeakReference<MediaControllerCompat.Callback> mCallback;
    
    StubCompat(MediaControllerCompat.Callback param1Callback) {
      this.mCallback = new WeakReference<MediaControllerCompat.Callback>(param1Callback);
    }
    
    public void onCaptioningEnabledChanged(boolean param1Boolean) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(11, Boolean.valueOf(param1Boolean), null); 
    }
    
    public void onEvent(String param1String, Bundle param1Bundle) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(1, param1String, param1Bundle); 
    }
    
    public void onExtrasChanged(Bundle param1Bundle) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(7, param1Bundle, null); 
    }
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(3, param1MediaMetadataCompat, null); 
    }
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(2, param1PlaybackStateCompat, null); 
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(5, param1List, null); 
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(6, param1CharSequence, null); 
    }
    
    public void onRepeatModeChanged(int param1Int) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(9, Integer.valueOf(param1Int), null); 
    }
    
    public void onSessionDestroyed() throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(8, null, null); 
    }
    
    public void onSessionReady() throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(13, null, null); 
    }
    
    public void onShuffleModeChanged(int param1Int) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null)
        callback.postToHandler(12, Integer.valueOf(param1Int), null); 
    }
    
    public void onShuffleModeChangedRemoved(boolean param1Boolean) throws RemoteException {}
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) throws RemoteException {
      MediaControllerCompat.Callback callback = this.mCallback.get();
      if (callback != null) {
        if (param1ParcelableVolumeInfo != null) {
          MediaControllerCompat.PlaybackInfo playbackInfo = new MediaControllerCompat.PlaybackInfo(param1ParcelableVolumeInfo.volumeType, param1ParcelableVolumeInfo.audioStream, param1ParcelableVolumeInfo.controlType, param1ParcelableVolumeInfo.maxVolume, param1ParcelableVolumeInfo.currentVolume);
        } else {
          param1ParcelableVolumeInfo = null;
        } 
        callback.postToHandler(4, param1ParcelableVolumeInfo, null);
      } 
    }
  }
  
  static interface MediaControllerImpl {
    void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat);
    
    void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int);
    
    void adjustVolume(int param1Int1, int param1Int2);
    
    boolean dispatchMediaButtonEvent(KeyEvent param1KeyEvent);
    
    Bundle getExtras();
    
    long getFlags();
    
    Object getMediaController();
    
    MediaMetadataCompat getMetadata();
    
    String getPackageName();
    
    MediaControllerCompat.PlaybackInfo getPlaybackInfo();
    
    PlaybackStateCompat getPlaybackState();
    
    List<MediaSessionCompat.QueueItem> getQueue();
    
    CharSequence getQueueTitle();
    
    int getRatingType();
    
    int getRepeatMode();
    
    PendingIntent getSessionActivity();
    
    Bundle getSessionInfo();
    
    int getShuffleMode();
    
    MediaControllerCompat.TransportControls getTransportControls();
    
    boolean isCaptioningEnabled();
    
    boolean isSessionReady();
    
    void registerCallback(MediaControllerCompat.Callback param1Callback, Handler param1Handler);
    
    void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat);
    
    void sendCommand(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver);
    
    void setVolumeTo(int param1Int1, int param1Int2);
    
    void unregisterCallback(MediaControllerCompat.Callback param1Callback);
  }
  
  static class MediaControllerImplApi21 implements MediaControllerImpl {
    private HashMap<MediaControllerCompat.Callback, ExtraCallback> mCallbackMap = new HashMap<MediaControllerCompat.Callback, ExtraCallback>();
    
    protected final MediaController mControllerFwk;
    
    final Object mLock = new Object();
    
    private final List<MediaControllerCompat.Callback> mPendingCallbacks = new ArrayList<MediaControllerCompat.Callback>();
    
    private Bundle mSessionInfo;
    
    final MediaSessionCompat.Token mSessionToken;
    
    MediaControllerImplApi21(Context param1Context, MediaSessionCompat.Token param1Token) {
      this.mSessionToken = param1Token;
      this.mControllerFwk = new MediaController(param1Context, (MediaSession.Token)param1Token.getToken());
      if (param1Token.getExtraBinder() == null)
        requestExtraBinder(); 
    }
    
    private void requestExtraBinder() {
      ExtraBinderRequestResultReceiver extraBinderRequestResultReceiver = new ExtraBinderRequestResultReceiver(this);
      sendCommand(v416f9e89.xbd520268("871"), null, extraBinderRequestResultReceiver);
    }
    
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      if ((getFlags() & 0x4L) != 0L) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(v416f9e89.xbd520268("872"), (Parcelable)param1MediaDescriptionCompat);
        sendCommand(v416f9e89.xbd520268("873"), bundle, null);
        return;
      } 
      throw new UnsupportedOperationException(v416f9e89.xbd520268("874"));
    }
    
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      if ((getFlags() & 0x4L) != 0L) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(v416f9e89.xbd520268("875"), (Parcelable)param1MediaDescriptionCompat);
        bundle.putInt(v416f9e89.xbd520268("876"), param1Int);
        sendCommand(v416f9e89.xbd520268("877"), bundle, null);
        return;
      } 
      throw new UnsupportedOperationException(v416f9e89.xbd520268("878"));
    }
    
    public void adjustVolume(int param1Int1, int param1Int2) {
      this.mControllerFwk.adjustVolume(param1Int1, param1Int2);
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent param1KeyEvent) {
      return this.mControllerFwk.dispatchMediaButtonEvent(param1KeyEvent);
    }
    
    public Bundle getExtras() {
      return this.mControllerFwk.getExtras();
    }
    
    public long getFlags() {
      return this.mControllerFwk.getFlags();
    }
    
    public Object getMediaController() {
      return this.mControllerFwk;
    }
    
    public MediaMetadataCompat getMetadata() {
      MediaMetadata mediaMetadata = this.mControllerFwk.getMetadata();
      return (mediaMetadata != null) ? MediaMetadataCompat.fromMediaMetadata(mediaMetadata) : null;
    }
    
    public String getPackageName() {
      return this.mControllerFwk.getPackageName();
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
      MediaController.PlaybackInfo playbackInfo = this.mControllerFwk.getPlaybackInfo();
      return (playbackInfo != null) ? new MediaControllerCompat.PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()) : null;
    }
    
    public PlaybackStateCompat getPlaybackState() {
      if (this.mSessionToken.getExtraBinder() != null)
        try {
          return this.mSessionToken.getExtraBinder().getPlaybackState();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("879"), v416f9e89.xbd520268("880"), (Throwable)remoteException);
        }  
      PlaybackState playbackState = this.mControllerFwk.getPlaybackState();
      return (playbackState != null) ? PlaybackStateCompat.fromPlaybackState(playbackState) : null;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
      List<?> list = this.mControllerFwk.getQueue();
      return (list != null) ? MediaSessionCompat.QueueItem.fromQueueItemList(list) : null;
    }
    
    public CharSequence getQueueTitle() {
      return this.mControllerFwk.getQueueTitle();
    }
    
    public int getRatingType() {
      if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null)
        try {
          return this.mSessionToken.getExtraBinder().getRatingType();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("881"), v416f9e89.xbd520268("882"), (Throwable)remoteException);
        }  
      return this.mControllerFwk.getRatingType();
    }
    
    public int getRepeatMode() {
      if (this.mSessionToken.getExtraBinder() != null)
        try {
          return this.mSessionToken.getExtraBinder().getRepeatMode();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("883"), v416f9e89.xbd520268("884"), (Throwable)remoteException);
        }  
      return -1;
    }
    
    public PendingIntent getSessionActivity() {
      return this.mControllerFwk.getSessionActivity();
    }
    
    public Bundle getSessionInfo() {
      if (this.mSessionInfo != null)
        return new Bundle(this.mSessionInfo); 
      if (Build.VERSION.SDK_INT >= 29) {
        this.mSessionInfo = this.mControllerFwk.getSessionInfo();
      } else if (this.mSessionToken.getExtraBinder() != null) {
        try {
          this.mSessionInfo = this.mSessionToken.getExtraBinder().getSessionInfo();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("885"), v416f9e89.xbd520268("886"), (Throwable)remoteException);
          this.mSessionInfo = Bundle.EMPTY;
        } 
      } 
      Bundle bundle = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
      this.mSessionInfo = bundle;
      return (bundle == null) ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
    }
    
    public int getShuffleMode() {
      if (this.mSessionToken.getExtraBinder() != null)
        try {
          return this.mSessionToken.getExtraBinder().getShuffleMode();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("887"), v416f9e89.xbd520268("888"), (Throwable)remoteException);
        }  
      return -1;
    }
    
    public MediaControllerCompat.TransportControls getTransportControls() {
      return new MediaControllerCompat.TransportControlsApi21(this.mControllerFwk.getTransportControls());
    }
    
    public boolean isCaptioningEnabled() {
      if (this.mSessionToken.getExtraBinder() != null)
        try {
          return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("889"), v416f9e89.xbd520268("890"), (Throwable)remoteException);
        }  
      return false;
    }
    
    public boolean isSessionReady() {
      return (this.mSessionToken.getExtraBinder() != null);
    }
    
    void processPendingCallbacksLocked() {
      if (this.mSessionToken.getExtraBinder() == null)
        return; 
      Iterator<MediaControllerCompat.Callback> iterator = this.mPendingCallbacks.iterator();
      while (iterator.hasNext()) {
        MediaControllerCompat.Callback callback = iterator.next();
        ExtraCallback extraCallback = new ExtraCallback(callback);
        this.mCallbackMap.put(callback, extraCallback);
        callback.mIControllerCallback = extraCallback;
        try {
          this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
          callback.postToHandler(13, null, null);
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("891"), v416f9e89.xbd520268("892"), (Throwable)remoteException);
          break;
        } 
      } 
      this.mPendingCallbacks.clear();
    }
    
    public final void registerCallback(MediaControllerCompat.Callback param1Callback, Handler param1Handler) {
      this.mControllerFwk.registerCallback(param1Callback.mCallbackFwk, param1Handler);
      synchronized (this.mLock) {
        if (this.mSessionToken.getExtraBinder() != null) {
          ExtraCallback extraCallback = new ExtraCallback(param1Callback);
          this.mCallbackMap.put(param1Callback, extraCallback);
          param1Callback.mIControllerCallback = extraCallback;
          try {
            this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
            param1Callback.postToHandler(13, null, null);
          } catch (RemoteException remoteException) {
            Log.e(v416f9e89.xbd520268("893"), v416f9e89.xbd520268("894"), (Throwable)remoteException);
          } 
        } else {
          ((MediaControllerCompat.Callback)remoteException).mIControllerCallback = null;
          this.mPendingCallbacks.add(remoteException);
        } 
        return;
      } 
    }
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      if ((getFlags() & 0x4L) != 0L) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(v416f9e89.xbd520268("895"), (Parcelable)param1MediaDescriptionCompat);
        sendCommand(v416f9e89.xbd520268("896"), bundle, null);
        return;
      } 
      throw new UnsupportedOperationException(v416f9e89.xbd520268("897"));
    }
    
    public void sendCommand(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {
      this.mControllerFwk.sendCommand(param1String, param1Bundle, param1ResultReceiver);
    }
    
    public void setVolumeTo(int param1Int1, int param1Int2) {
      this.mControllerFwk.setVolumeTo(param1Int1, param1Int2);
    }
    
    public final void unregisterCallback(MediaControllerCompat.Callback param1Callback) {
      this.mControllerFwk.unregisterCallback(param1Callback.mCallbackFwk);
      synchronized (this.mLock) {
        IMediaSession iMediaSession = this.mSessionToken.getExtraBinder();
        if (iMediaSession != null) {
          try {
            ExtraCallback extraCallback = this.mCallbackMap.remove(param1Callback);
            if (extraCallback != null) {
              param1Callback.mIControllerCallback = null;
              this.mSessionToken.getExtraBinder().unregisterCallbackListener(extraCallback);
            } 
          } catch (RemoteException remoteException) {
            Log.e(v416f9e89.xbd520268("898"), v416f9e89.xbd520268("899"), (Throwable)remoteException);
          } 
        } else {
          this.mPendingCallbacks.remove(remoteException);
        } 
        return;
      } 
    }
    
    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> mMediaControllerImpl;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 param2MediaControllerImplApi21) {
        super(null);
        this.mMediaControllerImpl = new WeakReference<MediaControllerCompat.MediaControllerImplApi21>(param2MediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int param2Int, Bundle param2Bundle) {
        MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21 = this.mMediaControllerImpl.get();
        if (mediaControllerImplApi21 != null) {
          if (param2Bundle == null)
            return; 
          synchronized (mediaControllerImplApi21.mLock) {
            mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(param2Bundle, v416f9e89.xbd520268("869"))));
            mediaControllerImplApi21.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(param2Bundle, v416f9e89.xbd520268("870")));
            mediaControllerImplApi21.processPendingCallbacksLocked();
            return;
          } 
        } 
      }
    }
    
    private static class ExtraCallback extends MediaControllerCompat.Callback.StubCompat {
      ExtraCallback(MediaControllerCompat.Callback param2Callback) {
        super(param2Callback);
      }
      
      public void onExtrasChanged(Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void onMetadataChanged(MediaMetadataCompat param2MediaMetadataCompat) throws RemoteException {
        throw new AssertionError();
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> param2List) throws RemoteException {
        throw new AssertionError();
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) throws RemoteException {
        throw new AssertionError();
      }
      
      public void onSessionDestroyed() throws RemoteException {
        throw new AssertionError();
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo param2ParcelableVolumeInfo) throws RemoteException {
        throw new AssertionError();
      }
    }
  }
  
  private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
    private WeakReference<MediaControllerCompat.MediaControllerImplApi21> mMediaControllerImpl;
    
    ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 param1MediaControllerImplApi21) {
      super(null);
      this.mMediaControllerImpl = new WeakReference<MediaControllerCompat.MediaControllerImplApi21>(param1MediaControllerImplApi21);
    }
    
    protected void onReceiveResult(int param1Int, Bundle param1Bundle) {
      MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21 = this.mMediaControllerImpl.get();
      if (mediaControllerImplApi21 != null) {
        if (param1Bundle == null)
          return; 
        synchronized (mediaControllerImplApi21.mLock) {
          mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(param1Bundle, v416f9e89.xbd520268("869"))));
          mediaControllerImplApi21.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(param1Bundle, v416f9e89.xbd520268("870")));
          mediaControllerImplApi21.processPendingCallbacksLocked();
          return;
        } 
      } 
    }
  }
  
  private static class ExtraCallback extends Callback.StubCompat {
    ExtraCallback(MediaControllerCompat.Callback param1Callback) {
      super(param1Callback);
    }
    
    public void onExtrasChanged(Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) throws RemoteException {
      throw new AssertionError();
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) throws RemoteException {
      throw new AssertionError();
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) throws RemoteException {
      throw new AssertionError();
    }
    
    public void onSessionDestroyed() throws RemoteException {
      throw new AssertionError();
    }
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) throws RemoteException {
      throw new AssertionError();
    }
  }
  
  static class MediaControllerImplBase implements MediaControllerImpl {
    private IMediaSession mBinder;
    
    private Bundle mSessionInfo;
    
    private MediaControllerCompat.TransportControls mTransportControls;
    
    MediaControllerImplBase(MediaSessionCompat.Token param1Token) {
      this.mBinder = IMediaSession.Stub.asInterface((IBinder)param1Token.getToken());
    }
    
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      try {
        if ((this.mBinder.getFlags() & 0x4L) != 0L) {
          this.mBinder.addQueueItem(param1MediaDescriptionCompat);
          return;
        } 
        throw new UnsupportedOperationException(v416f9e89.xbd520268("60"));
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("61"), v416f9e89.xbd520268("62"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      try {
        if ((this.mBinder.getFlags() & 0x4L) != 0L) {
          this.mBinder.addQueueItemAt(param1MediaDescriptionCompat, param1Int);
          return;
        } 
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("63"), v416f9e89.xbd520268("64"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void adjustVolume(int param1Int1, int param1Int2) {
      try {
        this.mBinder.adjustVolume(param1Int1, param1Int2, (String)null);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("65"), v416f9e89.xbd520268("66"), (Throwable)remoteException);
        return;
      } 
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent param1KeyEvent) {
      if (param1KeyEvent != null) {
        try {
          this.mBinder.sendMediaButton(param1KeyEvent);
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("67"), v416f9e89.xbd520268("68"), (Throwable)remoteException);
        } 
        return false;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("69"));
    }
    
    public Bundle getExtras() {
      try {
        return this.mBinder.getExtras();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("70"), v416f9e89.xbd520268("71"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public long getFlags() {
      try {
        return this.mBinder.getFlags();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("72"), v416f9e89.xbd520268("73"), (Throwable)remoteException);
        return 0L;
      } 
    }
    
    public Object getMediaController() {
      return null;
    }
    
    public MediaMetadataCompat getMetadata() {
      try {
        return this.mBinder.getMetadata();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("74"), v416f9e89.xbd520268("75"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public String getPackageName() {
      try {
        return this.mBinder.getPackageName();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("76"), v416f9e89.xbd520268("77"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
      try {
        ParcelableVolumeInfo parcelableVolumeInfo = this.mBinder.getVolumeAttributes();
        return new MediaControllerCompat.PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("78"), v416f9e89.xbd520268("79"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public PlaybackStateCompat getPlaybackState() {
      try {
        return this.mBinder.getPlaybackState();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("80"), v416f9e89.xbd520268("81"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
      try {
        return this.mBinder.getQueue();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("82"), v416f9e89.xbd520268("83"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public CharSequence getQueueTitle() {
      try {
        return this.mBinder.getQueueTitle();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("84"), v416f9e89.xbd520268("85"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public int getRatingType() {
      try {
        return this.mBinder.getRatingType();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("86"), v416f9e89.xbd520268("87"), (Throwable)remoteException);
        return 0;
      } 
    }
    
    public int getRepeatMode() {
      try {
        return this.mBinder.getRepeatMode();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("88"), v416f9e89.xbd520268("89"), (Throwable)remoteException);
        return -1;
      } 
    }
    
    public PendingIntent getSessionActivity() {
      try {
        return this.mBinder.getLaunchPendingIntent();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("90"), v416f9e89.xbd520268("91"), (Throwable)remoteException);
        return null;
      } 
    }
    
    public Bundle getSessionInfo() {
      try {
        this.mSessionInfo = this.mBinder.getSessionInfo();
      } catch (RemoteException remoteException) {
        Log.d(v416f9e89.xbd520268("92"), v416f9e89.xbd520268("93"), (Throwable)remoteException);
      } 
      Bundle bundle = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
      this.mSessionInfo = bundle;
      return (bundle == null) ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
    }
    
    public int getShuffleMode() {
      try {
        return this.mBinder.getShuffleMode();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("94"), v416f9e89.xbd520268("95"), (Throwable)remoteException);
        return -1;
      } 
    }
    
    public MediaControllerCompat.TransportControls getTransportControls() {
      if (this.mTransportControls == null)
        this.mTransportControls = new MediaControllerCompat.TransportControlsBase(this.mBinder); 
      return this.mTransportControls;
    }
    
    public boolean isCaptioningEnabled() {
      try {
        return this.mBinder.isCaptioningEnabled();
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("96"), v416f9e89.xbd520268("97"), (Throwable)remoteException);
        return false;
      } 
    }
    
    public boolean isSessionReady() {
      return true;
    }
    
    public void registerCallback(MediaControllerCompat.Callback param1Callback, Handler param1Handler) {
      if (param1Callback != null)
        try {
          this.mBinder.asBinder().linkToDeath(param1Callback, 0);
          this.mBinder.registerCallbackListener(param1Callback.mIControllerCallback);
          param1Callback.postToHandler(13, null, null);
          return;
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("98"), v416f9e89.xbd520268("99"), (Throwable)remoteException);
          param1Callback.postToHandler(8, null, null);
          return;
        }  
      throw new IllegalArgumentException(v416f9e89.xbd520268("100"));
    }
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      try {
        if ((this.mBinder.getFlags() & 0x4L) != 0L) {
          this.mBinder.removeQueueItem(param1MediaDescriptionCompat);
          return;
        } 
        throw new UnsupportedOperationException(v416f9e89.xbd520268("101"));
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("102"), v416f9e89.xbd520268("103"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void sendCommand(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {
      try {
        MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper;
        IMediaSession iMediaSession = this.mBinder;
        if (param1ResultReceiver == null) {
          param1ResultReceiver = null;
        } else {
          resultReceiverWrapper = new MediaSessionCompat.ResultReceiverWrapper(param1ResultReceiver);
        } 
        iMediaSession.sendCommand(param1String, param1Bundle, resultReceiverWrapper);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("104"), v416f9e89.xbd520268("105"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setVolumeTo(int param1Int1, int param1Int2) {
      try {
        this.mBinder.setVolumeTo(param1Int1, param1Int2, (String)null);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("106"), v416f9e89.xbd520268("107"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void unregisterCallback(MediaControllerCompat.Callback param1Callback) {
      if (param1Callback != null)
        try {
          this.mBinder.unregisterCallbackListener(param1Callback.mIControllerCallback);
          this.mBinder.asBinder().unlinkToDeath(param1Callback, 0);
          return;
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("108"), v416f9e89.xbd520268("109"), (Throwable)remoteException);
          return;
        }  
      throw new IllegalArgumentException(v416f9e89.xbd520268("110"));
    }
  }
  
  public static final class PlaybackInfo {
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    
    private final AudioAttributesCompat mAudioAttrsCompat;
    
    private final int mCurrentVolume;
    
    private final int mMaxVolume;
    
    private final int mPlaybackType;
    
    private final int mVolumeControl;
    
    PlaybackInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      this(param1Int1, (new AudioAttributesCompat.Builder()).setLegacyStreamType(param1Int2).build(), param1Int3, param1Int4, param1Int5);
    }
    
    PlaybackInfo(int param1Int1, AudioAttributesCompat param1AudioAttributesCompat, int param1Int2, int param1Int3, int param1Int4) {
      this.mPlaybackType = param1Int1;
      this.mAudioAttrsCompat = param1AudioAttributesCompat;
      this.mVolumeControl = param1Int2;
      this.mMaxVolume = param1Int3;
      this.mCurrentVolume = param1Int4;
    }
    
    public AudioAttributesCompat getAudioAttributes() {
      return this.mAudioAttrsCompat;
    }
    
    @Deprecated
    public int getAudioStream() {
      return this.mAudioAttrsCompat.getLegacyStreamType();
    }
    
    public int getCurrentVolume() {
      return this.mCurrentVolume;
    }
    
    public int getMaxVolume() {
      return this.mMaxVolume;
    }
    
    public int getPlaybackType() {
      return this.mPlaybackType;
    }
    
    public int getVolumeControl() {
      return this.mVolumeControl;
    }
  }
  
  public static abstract class TransportControls {
    public static final String EXTRA_LEGACY_STREAM_TYPE = v416f9e89.xbd520268("118");
    
    public abstract void fastForward();
    
    public abstract void pause();
    
    public abstract void play();
    
    public abstract void playFromMediaId(String param1String, Bundle param1Bundle);
    
    public abstract void playFromSearch(String param1String, Bundle param1Bundle);
    
    public abstract void playFromUri(Uri param1Uri, Bundle param1Bundle);
    
    public abstract void prepare();
    
    public abstract void prepareFromMediaId(String param1String, Bundle param1Bundle);
    
    public abstract void prepareFromSearch(String param1String, Bundle param1Bundle);
    
    public abstract void prepareFromUri(Uri param1Uri, Bundle param1Bundle);
    
    public abstract void rewind();
    
    public abstract void seekTo(long param1Long);
    
    public abstract void sendCustomAction(PlaybackStateCompat.CustomAction param1CustomAction, Bundle param1Bundle);
    
    public abstract void sendCustomAction(String param1String, Bundle param1Bundle);
    
    public abstract void setCaptioningEnabled(boolean param1Boolean);
    
    public void setPlaybackSpeed(float param1Float) {}
    
    public abstract void setRating(RatingCompat param1RatingCompat);
    
    public abstract void setRating(RatingCompat param1RatingCompat, Bundle param1Bundle);
    
    public abstract void setRepeatMode(int param1Int);
    
    public abstract void setShuffleMode(int param1Int);
    
    public abstract void skipToNext();
    
    public abstract void skipToPrevious();
    
    public abstract void skipToQueueItem(long param1Long);
    
    public abstract void stop();
  }
  
  static class TransportControlsApi21 extends TransportControls {
    protected final MediaController.TransportControls mControlsFwk;
    
    TransportControlsApi21(MediaController.TransportControls param1TransportControls) {
      this.mControlsFwk = param1TransportControls;
    }
    
    public void fastForward() {
      this.mControlsFwk.fastForward();
    }
    
    public void pause() {
      this.mControlsFwk.pause();
    }
    
    public void play() {
      this.mControlsFwk.play();
    }
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) {
      this.mControlsFwk.playFromMediaId(param1String, param1Bundle);
    }
    
    public void playFromSearch(String param1String, Bundle param1Bundle) {
      this.mControlsFwk.playFromSearch(param1String, param1Bundle);
    }
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT >= 23) {
        this.mControlsFwk.playFromUri(param1Uri, param1Bundle);
        return;
      } 
      if (param1Uri != null && !Uri.EMPTY.equals(param1Uri)) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(v416f9e89.xbd520268("122"), (Parcelable)param1Uri);
        bundle.putBundle(v416f9e89.xbd520268("123"), param1Bundle);
        sendCustomAction(v416f9e89.xbd520268("124"), bundle);
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("125"));
    }
    
    public void prepare() {
      if (Build.VERSION.SDK_INT >= 24) {
        this.mControlsFwk.prepare();
        return;
      } 
      sendCustomAction(v416f9e89.xbd520268("126"), (Bundle)null);
    }
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT >= 24) {
        this.mControlsFwk.prepareFromMediaId(param1String, param1Bundle);
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putString(v416f9e89.xbd520268("127"), param1String);
      bundle.putBundle(v416f9e89.xbd520268("128"), param1Bundle);
      sendCustomAction(v416f9e89.xbd520268("129"), bundle);
    }
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT >= 24) {
        this.mControlsFwk.prepareFromSearch(param1String, param1Bundle);
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putString(v416f9e89.xbd520268("130"), param1String);
      bundle.putBundle(v416f9e89.xbd520268("131"), param1Bundle);
      sendCustomAction(v416f9e89.xbd520268("132"), bundle);
    }
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT >= 24) {
        this.mControlsFwk.prepareFromUri(param1Uri, param1Bundle);
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putParcelable(v416f9e89.xbd520268("133"), (Parcelable)param1Uri);
      bundle.putBundle(v416f9e89.xbd520268("134"), param1Bundle);
      sendCustomAction(v416f9e89.xbd520268("135"), bundle);
    }
    
    public void rewind() {
      this.mControlsFwk.rewind();
    }
    
    public void seekTo(long param1Long) {
      this.mControlsFwk.seekTo(param1Long);
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction param1CustomAction, Bundle param1Bundle) {
      MediaControllerCompat.validateCustomAction(param1CustomAction.getAction(), param1Bundle);
      this.mControlsFwk.sendCustomAction(param1CustomAction.getAction(), param1Bundle);
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) {
      MediaControllerCompat.validateCustomAction(param1String, param1Bundle);
      this.mControlsFwk.sendCustomAction(param1String, param1Bundle);
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) {
      Bundle bundle = new Bundle();
      bundle.putBoolean(v416f9e89.xbd520268("136"), param1Boolean);
      sendCustomAction(v416f9e89.xbd520268("137"), bundle);
    }
    
    public void setPlaybackSpeed(float param1Float) {
      if (param1Float != 0.0F) {
        if (Build.VERSION.SDK_INT >= 29) {
          this.mControlsFwk.setPlaybackSpeed(param1Float);
          return;
        } 
        Bundle bundle = new Bundle();
        bundle.putFloat(v416f9e89.xbd520268("138"), param1Float);
        sendCustomAction(v416f9e89.xbd520268("139"), bundle);
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("140"));
    }
    
    public void setRating(RatingCompat param1RatingCompat) {
      MediaController.TransportControls transportControls = this.mControlsFwk;
      if (param1RatingCompat != null) {
        Rating rating = (Rating)param1RatingCompat.getRating();
      } else {
        param1RatingCompat = null;
      } 
      transportControls.setRating((Rating)param1RatingCompat);
    }
    
    public void setRating(RatingCompat param1RatingCompat, Bundle param1Bundle) {
      Bundle bundle = new Bundle();
      bundle.putParcelable(v416f9e89.xbd520268("141"), (Parcelable)param1RatingCompat);
      bundle.putBundle(v416f9e89.xbd520268("142"), param1Bundle);
      sendCustomAction(v416f9e89.xbd520268("143"), bundle);
    }
    
    public void setRepeatMode(int param1Int) {
      Bundle bundle = new Bundle();
      bundle.putInt(v416f9e89.xbd520268("144"), param1Int);
      sendCustomAction(v416f9e89.xbd520268("145"), bundle);
    }
    
    public void setShuffleMode(int param1Int) {
      Bundle bundle = new Bundle();
      bundle.putInt(v416f9e89.xbd520268("146"), param1Int);
      sendCustomAction(v416f9e89.xbd520268("147"), bundle);
    }
    
    public void skipToNext() {
      this.mControlsFwk.skipToNext();
    }
    
    public void skipToPrevious() {
      this.mControlsFwk.skipToPrevious();
    }
    
    public void skipToQueueItem(long param1Long) {
      this.mControlsFwk.skipToQueueItem(param1Long);
    }
    
    public void stop() {
      this.mControlsFwk.stop();
    }
  }
  
  static class TransportControlsBase extends TransportControls {
    private IMediaSession mBinder;
    
    public TransportControlsBase(IMediaSession param1IMediaSession) {
      this.mBinder = param1IMediaSession;
    }
    
    public void fastForward() {
      try {
        this.mBinder.fastForward();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("162"), v416f9e89.xbd520268("163"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void pause() {
      try {
        this.mBinder.pause();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("164"), v416f9e89.xbd520268("165"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void play() {
      try {
        this.mBinder.play();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("166"), v416f9e89.xbd520268("167"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) {
      try {
        this.mBinder.playFromMediaId(param1String, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("168"), v416f9e89.xbd520268("169"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void playFromSearch(String param1String, Bundle param1Bundle) {
      try {
        this.mBinder.playFromSearch(param1String, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("170"), v416f9e89.xbd520268("171"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) {
      try {
        this.mBinder.playFromUri(param1Uri, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("172"), v416f9e89.xbd520268("173"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void prepare() {
      try {
        this.mBinder.prepare();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("174"), v416f9e89.xbd520268("175"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) {
      try {
        this.mBinder.prepareFromMediaId(param1String, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("176"), v416f9e89.xbd520268("177"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) {
      try {
        this.mBinder.prepareFromSearch(param1String, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("178"), v416f9e89.xbd520268("179"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) {
      try {
        this.mBinder.prepareFromUri(param1Uri, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("180"), v416f9e89.xbd520268("181"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void rewind() {
      try {
        this.mBinder.rewind();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("182"), v416f9e89.xbd520268("183"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void seekTo(long param1Long) {
      try {
        this.mBinder.seekTo(param1Long);
        return;
      } catch (RemoteException remoteException) {
        Log.e("MediaControllerCompat", v416f9e89.xbd520268("184"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction param1CustomAction, Bundle param1Bundle) {
      sendCustomAction(param1CustomAction.getAction(), param1Bundle);
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) {
      MediaControllerCompat.validateCustomAction(param1String, param1Bundle);
      try {
        this.mBinder.sendCustomAction(param1String, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("185"), v416f9e89.xbd520268("186"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) {
      try {
        this.mBinder.setCaptioningEnabled(param1Boolean);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("187"), v416f9e89.xbd520268("188"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setPlaybackSpeed(float param1Float) {
      if (param1Float != 0.0F)
        try {
          this.mBinder.setPlaybackSpeed(param1Float);
          return;
        } catch (RemoteException remoteException) {
          Log.e(v416f9e89.xbd520268("189"), v416f9e89.xbd520268("190"), (Throwable)remoteException);
          return;
        }  
      throw new IllegalArgumentException(v416f9e89.xbd520268("191"));
    }
    
    public void setRating(RatingCompat param1RatingCompat) {
      try {
        this.mBinder.rate(param1RatingCompat);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("192"), v416f9e89.xbd520268("193"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setRating(RatingCompat param1RatingCompat, Bundle param1Bundle) {
      try {
        this.mBinder.rateWithExtras(param1RatingCompat, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("194"), v416f9e89.xbd520268("195"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setRepeatMode(int param1Int) {
      try {
        this.mBinder.setRepeatMode(param1Int);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("196"), v416f9e89.xbd520268("197"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void setShuffleMode(int param1Int) {
      try {
        this.mBinder.setShuffleMode(param1Int);
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("198"), v416f9e89.xbd520268("199"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void skipToNext() {
      try {
        this.mBinder.next();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("200"), v416f9e89.xbd520268("201"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void skipToPrevious() {
      try {
        this.mBinder.previous();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("202"), v416f9e89.xbd520268("203"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void skipToQueueItem(long param1Long) {
      try {
        this.mBinder.skipToQueueItem(param1Long);
        return;
      } catch (RemoteException remoteException) {
        Log.e("MediaControllerCompat", v416f9e89.xbd520268("204"), (Throwable)remoteException);
        return;
      } 
    }
    
    public void stop() {
      try {
        this.mBinder.stop();
        return;
      } catch (RemoteException remoteException) {
        Log.e(v416f9e89.xbd520268("205"), v416f9e89.xbd520268("206"), (Throwable)remoteException);
        return;
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */