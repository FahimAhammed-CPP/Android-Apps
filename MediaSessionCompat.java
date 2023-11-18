package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import h8800e55c.pc41fcc5f.v416f9e89;
import h8800e55c.x78d2f21c.y0bc38925;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
  public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = v416f9e89.xbd520268("691");
  
  public static final String ACTION_ARGUMENT_EXTRAS = v416f9e89.xbd520268("692");
  
  public static final String ACTION_ARGUMENT_MEDIA_ID = v416f9e89.xbd520268("693");
  
  public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = v416f9e89.xbd520268("694");
  
  public static final String ACTION_ARGUMENT_QUERY = v416f9e89.xbd520268("695");
  
  public static final String ACTION_ARGUMENT_RATING = v416f9e89.xbd520268("696");
  
  public static final String ACTION_ARGUMENT_REPEAT_MODE = v416f9e89.xbd520268("697");
  
  public static final String ACTION_ARGUMENT_SHUFFLE_MODE = v416f9e89.xbd520268("698");
  
  public static final String ACTION_ARGUMENT_URI = v416f9e89.xbd520268("699");
  
  public static final String ACTION_FLAG_AS_INAPPROPRIATE = v416f9e89.xbd520268("700");
  
  public static final String ACTION_FOLLOW = v416f9e89.xbd520268("701");
  
  public static final String ACTION_PLAY_FROM_URI = v416f9e89.xbd520268("702");
  
  public static final String ACTION_PREPARE = v416f9e89.xbd520268("703");
  
  public static final String ACTION_PREPARE_FROM_MEDIA_ID = v416f9e89.xbd520268("704");
  
  public static final String ACTION_PREPARE_FROM_SEARCH = v416f9e89.xbd520268("705");
  
  public static final String ACTION_PREPARE_FROM_URI = v416f9e89.xbd520268("706");
  
  public static final String ACTION_SET_CAPTIONING_ENABLED = v416f9e89.xbd520268("707");
  
  public static final String ACTION_SET_PLAYBACK_SPEED = v416f9e89.xbd520268("708");
  
  public static final String ACTION_SET_RATING = v416f9e89.xbd520268("709");
  
  public static final String ACTION_SET_REPEAT_MODE = v416f9e89.xbd520268("710");
  
  public static final String ACTION_SET_SHUFFLE_MODE = v416f9e89.xbd520268("711");
  
  public static final String ACTION_SKIP_AD = v416f9e89.xbd520268("712");
  
  public static final String ACTION_UNFOLLOW = v416f9e89.xbd520268("713");
  
  public static final String ARGUMENT_MEDIA_ATTRIBUTE = v416f9e89.xbd520268("714");
  
  public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = v416f9e89.xbd520268("715");
  
  private static final String DATA_CALLING_PACKAGE = v416f9e89.xbd520268("716");
  
  private static final String DATA_CALLING_PID = v416f9e89.xbd520268("717");
  
  private static final String DATA_CALLING_UID = v416f9e89.xbd520268("718");
  
  private static final String DATA_EXTRAS = v416f9e89.xbd520268("719");
  
  @Deprecated
  public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
  
  public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
  
  @Deprecated
  public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
  
  public static final String KEY_EXTRA_BINDER = v416f9e89.xbd520268("720");
  
  public static final String KEY_SESSION2_TOKEN = v416f9e89.xbd520268("721");
  
  public static final String KEY_TOKEN = v416f9e89.xbd520268("722");
  
  private static final int MAX_BITMAP_SIZE_IN_DP = 320;
  
  public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
  
  public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
  
  public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
  
  static final String TAG = v416f9e89.xbd520268("723");
  
  static int sMaxBitmapSize;
  
  private final ArrayList<OnActiveChangeListener> mActiveListeners = new ArrayList<OnActiveChangeListener>();
  
  private final MediaControllerCompat mController;
  
  private final MediaSessionImpl mImpl;
  
  private MediaSessionCompat(Context paramContext, MediaSessionImpl paramMediaSessionImpl) {
    this.mImpl = paramMediaSessionImpl;
    this.mController = new MediaControllerCompat(paramContext, this);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString) {
    this(paramContext, paramString, null, null);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent) {
    this(paramContext, paramString, paramComponentName, paramPendingIntent, null);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent, Bundle paramBundle) {
    this(paramContext, paramString, paramComponentName, paramPendingIntent, paramBundle, null);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent, Bundle paramBundle, VersionedParcelable paramVersionedParcelable) {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString)) {
        Handler handler;
        ComponentName componentName = paramComponentName;
        if (paramComponentName == null) {
          paramComponentName = MediaButtonReceiver.getMediaButtonReceiverComponent(paramContext);
          componentName = paramComponentName;
          if (paramComponentName == null) {
            Log.w(v416f9e89.xbd520268("724"), v416f9e89.xbd520268("725"));
            componentName = paramComponentName;
          } 
        } 
        PendingIntent pendingIntent = paramPendingIntent;
        if (componentName != null) {
          pendingIntent = paramPendingIntent;
          if (paramPendingIntent == null) {
            Intent intent = new Intent(v416f9e89.xbd520268("726"));
            intent.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(paramContext, 0, intent, 0);
          } 
        } 
        if (Build.VERSION.SDK_INT >= 21) {
          Looper looper;
          MediaSession mediaSession = createFwkMediaSession(paramContext, paramString, paramBundle);
          if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new MediaSessionImplApi29(mediaSession, paramVersionedParcelable, paramBundle);
          } else if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionImplApi28(mediaSession, paramVersionedParcelable, paramBundle);
          } else {
            this.mImpl = new MediaSessionImplApi21(mediaSession, paramVersionedParcelable, paramBundle);
          } 
          if (Looper.myLooper() != null) {
            looper = Looper.myLooper();
          } else {
            looper = Looper.getMainLooper();
          } 
          handler = new Handler(looper);
          setCallback(new Callback() {
              
              },  handler);
          this.mImpl.setMediaButtonReceiver(pendingIntent);
        } else if (Build.VERSION.SDK_INT >= 19) {
          this.mImpl = new MediaSessionImplApi19(paramContext, (String)handler, componentName, pendingIntent, paramVersionedParcelable, paramBundle);
        } else if (Build.VERSION.SDK_INT >= 18) {
          this.mImpl = new MediaSessionImplApi18(paramContext, (String)handler, componentName, pendingIntent, paramVersionedParcelable, paramBundle);
        } else {
          this.mImpl = new MediaSessionImplBase(paramContext, (String)handler, componentName, pendingIntent, paramVersionedParcelable, paramBundle);
        } 
        this.mController = new MediaControllerCompat(paramContext, this);
        if (sMaxBitmapSize == 0)
          sMaxBitmapSize = (int)(TypedValue.applyDimension(1, 320.0F, paramContext.getResources().getDisplayMetrics()) + 0.5F); 
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("727"));
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("728"));
  }
  
  private MediaSession createFwkMediaSession(Context paramContext, String paramString, Bundle paramBundle) {
    return (Build.VERSION.SDK_INT >= 29) ? new MediaSession(paramContext, paramString, paramBundle) : new MediaSession(paramContext, paramString);
  }
  
  public static void ensureClassLoader(Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(MediaSessionCompat.class.getClassLoader()); 
  }
  
  public static MediaSessionCompat fromMediaSession(Context paramContext, Object paramObject) {
    if (Build.VERSION.SDK_INT < 21 || paramContext == null || paramObject == null)
      return null; 
    if (Build.VERSION.SDK_INT >= 29) {
      paramObject = new MediaSessionImplApi29(paramObject);
    } else if (Build.VERSION.SDK_INT >= 28) {
      paramObject = new MediaSessionImplApi28(paramObject);
    } else {
      paramObject = new MediaSessionImplApi21(paramObject);
    } 
    return new MediaSessionCompat(paramContext, (MediaSessionImpl)paramObject);
  }
  
  static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat paramPlaybackStateCompat, MediaMetadataCompat paramMediaMetadataCompat) {
    // Byte code:
    //   0: aload_0
    //   1: astore #10
    //   3: aload_0
    //   4: ifnull -> 183
    //   7: aload_0
    //   8: invokevirtual getPosition : ()J
    //   11: lstore_2
    //   12: ldc2_w -1
    //   15: lstore #4
    //   17: lload_2
    //   18: ldc2_w -1
    //   21: lcmp
    //   22: ifne -> 27
    //   25: aload_0
    //   26: areturn
    //   27: aload_0
    //   28: invokevirtual getState : ()I
    //   31: iconst_3
    //   32: if_icmpeq -> 54
    //   35: aload_0
    //   36: invokevirtual getState : ()I
    //   39: iconst_4
    //   40: if_icmpeq -> 54
    //   43: aload_0
    //   44: astore #10
    //   46: aload_0
    //   47: invokevirtual getState : ()I
    //   50: iconst_5
    //   51: if_icmpne -> 183
    //   54: aload_0
    //   55: invokevirtual getLastPositionUpdateTime : ()J
    //   58: lstore_2
    //   59: aload_0
    //   60: astore #10
    //   62: lload_2
    //   63: lconst_0
    //   64: lcmp
    //   65: ifle -> 183
    //   68: invokestatic elapsedRealtime : ()J
    //   71: lstore #8
    //   73: aload_0
    //   74: invokevirtual getPlaybackSpeed : ()F
    //   77: lload #8
    //   79: lload_2
    //   80: lsub
    //   81: l2f
    //   82: fmul
    //   83: f2l
    //   84: aload_0
    //   85: invokevirtual getPosition : ()J
    //   88: ladd
    //   89: lstore #6
    //   91: lload #4
    //   93: lstore_2
    //   94: aload_1
    //   95: ifnull -> 125
    //   98: ldc_w '729'
    //   101: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
    //   104: astore #10
    //   106: lload #4
    //   108: lstore_2
    //   109: aload_1
    //   110: aload #10
    //   112: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   115: ifeq -> 125
    //   118: aload_1
    //   119: aload #10
    //   121: invokevirtual getLong : (Ljava/lang/String;)J
    //   124: lstore_2
    //   125: lload_2
    //   126: lconst_0
    //   127: lcmp
    //   128: iflt -> 141
    //   131: lload #6
    //   133: lload_2
    //   134: lcmp
    //   135: ifle -> 141
    //   138: goto -> 156
    //   141: lload #6
    //   143: lconst_0
    //   144: lcmp
    //   145: ifge -> 153
    //   148: lconst_0
    //   149: lstore_2
    //   150: goto -> 156
    //   153: lload #6
    //   155: lstore_2
    //   156: new android/support/v4/media/session/PlaybackStateCompat$Builder
    //   159: dup
    //   160: aload_0
    //   161: invokespecial <init> : (Landroid/support/v4/media/session/PlaybackStateCompat;)V
    //   164: aload_0
    //   165: invokevirtual getState : ()I
    //   168: lload_2
    //   169: aload_0
    //   170: invokevirtual getPlaybackSpeed : ()F
    //   173: lload #8
    //   175: invokevirtual setState : (IJFJ)Landroid/support/v4/media/session/PlaybackStateCompat$Builder;
    //   178: invokevirtual build : ()Landroid/support/v4/media/session/PlaybackStateCompat;
    //   181: astore #10
    //   183: aload #10
    //   185: areturn
  }
  
  public static Bundle unparcelWithClassLoader(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    ensureClassLoader(paramBundle);
    try {
      paramBundle.isEmpty();
      return paramBundle;
    } catch (BadParcelableException badParcelableException) {
      Log.e(v416f9e89.xbd520268("730"), v416f9e89.xbd520268("731"));
      return null;
    } 
  }
  
  public void addOnActiveChangeListener(OnActiveChangeListener paramOnActiveChangeListener) {
    if (paramOnActiveChangeListener != null) {
      this.mActiveListeners.add(paramOnActiveChangeListener);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("732"));
  }
  
  public String getCallingPackage() {
    return this.mImpl.getCallingPackage();
  }
  
  public MediaControllerCompat getController() {
    return this.mController;
  }
  
  public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
    return this.mImpl.getCurrentControllerInfo();
  }
  
  public Object getMediaSession() {
    return this.mImpl.getMediaSession();
  }
  
  public Object getRemoteControlClient() {
    return this.mImpl.getRemoteControlClient();
  }
  
  public Token getSessionToken() {
    return this.mImpl.getSessionToken();
  }
  
  public boolean isActive() {
    return this.mImpl.isActive();
  }
  
  public void release() {
    this.mImpl.release();
  }
  
  public void removeOnActiveChangeListener(OnActiveChangeListener paramOnActiveChangeListener) {
    if (paramOnActiveChangeListener != null) {
      this.mActiveListeners.remove(paramOnActiveChangeListener);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("733"));
  }
  
  public void sendSessionEvent(String paramString, Bundle paramBundle) {
    if (!TextUtils.isEmpty(paramString)) {
      this.mImpl.sendSessionEvent(paramString, paramBundle);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("734"));
  }
  
  public void setActive(boolean paramBoolean) {
    this.mImpl.setActive(paramBoolean);
    Iterator<OnActiveChangeListener> iterator = this.mActiveListeners.iterator();
    while (iterator.hasNext())
      ((OnActiveChangeListener)iterator.next()).onActiveChanged(); 
  }
  
  public void setCallback(Callback paramCallback) {
    setCallback(paramCallback, null);
  }
  
  public void setCallback(Callback paramCallback, Handler paramHandler) {
    if (paramCallback == null) {
      this.mImpl.setCallback(null, null);
      return;
    } 
    MediaSessionImpl mediaSessionImpl = this.mImpl;
    if (paramHandler == null)
      paramHandler = new Handler(); 
    mediaSessionImpl.setCallback(paramCallback, paramHandler);
  }
  
  public void setCaptioningEnabled(boolean paramBoolean) {
    this.mImpl.setCaptioningEnabled(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle) {
    this.mImpl.setExtras(paramBundle);
  }
  
  public void setFlags(int paramInt) {
    this.mImpl.setFlags(paramInt);
  }
  
  public void setMediaButtonReceiver(PendingIntent paramPendingIntent) {
    this.mImpl.setMediaButtonReceiver(paramPendingIntent);
  }
  
  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat) {
    this.mImpl.setMetadata(paramMediaMetadataCompat);
  }
  
  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat) {
    this.mImpl.setPlaybackState(paramPlaybackStateCompat);
  }
  
  public void setPlaybackToLocal(int paramInt) {
    this.mImpl.setPlaybackToLocal(paramInt);
  }
  
  public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat) {
    if (paramVolumeProviderCompat != null) {
      this.mImpl.setPlaybackToRemote(paramVolumeProviderCompat);
      return;
    } 
    throw new IllegalArgumentException(v416f9e89.xbd520268("735"));
  }
  
  public void setQueue(List<QueueItem> paramList) {
    if (paramList != null) {
      HashSet<Long> hashSet = new HashSet();
      for (QueueItem queueItem : paramList) {
        if (queueItem != null) {
          if (hashSet.contains(Long.valueOf(queueItem.getQueueId()))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(v416f9e89.xbd520268("736"));
            stringBuilder.append(queueItem.getQueueId());
            String str = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(v416f9e89.xbd520268("737"));
            Log.e(v416f9e89.xbd520268("738"), str, illegalArgumentException);
          } 
          hashSet.add(Long.valueOf(queueItem.getQueueId()));
          continue;
        } 
        throw new IllegalArgumentException(v416f9e89.xbd520268("739"));
      } 
    } 
    this.mImpl.setQueue(paramList);
  }
  
  public void setQueueTitle(CharSequence paramCharSequence) {
    this.mImpl.setQueueTitle(paramCharSequence);
  }
  
  public void setRatingType(int paramInt) {
    this.mImpl.setRatingType(paramInt);
  }
  
  public void setRepeatMode(int paramInt) {
    this.mImpl.setRepeatMode(paramInt);
  }
  
  public void setSessionActivity(PendingIntent paramPendingIntent) {
    this.mImpl.setSessionActivity(paramPendingIntent);
  }
  
  public void setShuffleMode(int paramInt) {
    this.mImpl.setShuffleMode(paramInt);
  }
  
  public static abstract class Callback {
    final MediaSession.Callback mCallbackFwk;
    
    CallbackHandler mCallbackHandler;
    
    final Object mLock = new Object();
    
    private boolean mMediaPlayPausePendingOnHandler;
    
    WeakReference<MediaSessionCompat.MediaSessionImpl> mSessionImpl;
    
    public Callback() {
      if (Build.VERSION.SDK_INT >= 21) {
        this.mCallbackFwk = new MediaSessionCallbackApi21();
      } else {
        this.mCallbackFwk = null;
      } 
      this.mSessionImpl = new WeakReference<MediaSessionCompat.MediaSessionImpl>(null);
    }
    
    void handleMediaPlayPauseIfPendingOnHandler(MediaSessionCompat.MediaSessionImpl param1MediaSessionImpl, Handler param1Handler) {
      boolean bool1;
      boolean bool2;
      long l;
      if (!this.mMediaPlayPausePendingOnHandler)
        return; 
      boolean bool3 = false;
      this.mMediaPlayPausePendingOnHandler = false;
      param1Handler.removeMessages(1);
      PlaybackStateCompat playbackStateCompat = param1MediaSessionImpl.getPlaybackState();
      if (playbackStateCompat == null) {
        l = 0L;
      } else {
        l = playbackStateCompat.getActions();
      } 
      if (playbackStateCompat != null && playbackStateCompat.getState() == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if ((0x204L & l) != 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if ((l & 0x202L) != 0L)
        bool3 = true; 
      if (bool1 && bool3) {
        onPause();
        return;
      } 
      if (!bool1 && bool2)
        onPlay(); 
    }
    
    public void onAddQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {}
    
    public void onAddQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {}
    
    public void onCommand(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {}
    
    public void onCustomAction(String param1String, Bundle param1Bundle) {}
    
    public void onFastForward() {}
    
    public boolean onMediaButtonEvent(Intent param1Intent) {
      if (Build.VERSION.SDK_INT >= 27)
        return false; 
      synchronized (this.mLock) {
        MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mSessionImpl.get();
        CallbackHandler callbackHandler = this.mCallbackHandler;
        if (mediaSessionImpl != null) {
          if (callbackHandler == null)
            return false; 
          KeyEvent keyEvent = (KeyEvent)param1Intent.getParcelableExtra(v416f9e89.xbd520268("405"));
          if (keyEvent != null) {
            if (keyEvent.getAction() != 0)
              return false; 
            null = mediaSessionImpl.getCurrentControllerInfo();
            int i = keyEvent.getKeyCode();
            if (i != 79 && i != 85) {
              handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
              return false;
            } 
            if (keyEvent.getRepeatCount() == 0) {
              if (this.mMediaPlayPausePendingOnHandler) {
                long l;
                callbackHandler.removeMessages(1);
                this.mMediaPlayPausePendingOnHandler = false;
                PlaybackStateCompat playbackStateCompat = mediaSessionImpl.getPlaybackState();
                if (playbackStateCompat == null) {
                  l = 0L;
                } else {
                  l = playbackStateCompat.getActions();
                } 
                if ((l & 0x20L) != 0L) {
                  onSkipToNext();
                  return true;
                } 
              } else {
                this.mMediaPlayPausePendingOnHandler = true;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, null), ViewConfiguration.getDoubleTapTimeout());
                return true;
              } 
            } else {
              handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
            } 
            return true;
          } 
        } 
        return false;
      } 
    }
    
    public void onPause() {}
    
    public void onPlay() {}
    
    public void onPlayFromMediaId(String param1String, Bundle param1Bundle) {}
    
    public void onPlayFromSearch(String param1String, Bundle param1Bundle) {}
    
    public void onPlayFromUri(Uri param1Uri, Bundle param1Bundle) {}
    
    public void onPrepare() {}
    
    public void onPrepareFromMediaId(String param1String, Bundle param1Bundle) {}
    
    public void onPrepareFromSearch(String param1String, Bundle param1Bundle) {}
    
    public void onPrepareFromUri(Uri param1Uri, Bundle param1Bundle) {}
    
    public void onRemoveQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {}
    
    @Deprecated
    public void onRemoveQueueItemAt(int param1Int) {}
    
    public void onRewind() {}
    
    public void onSeekTo(long param1Long) {}
    
    public void onSetCaptioningEnabled(boolean param1Boolean) {}
    
    public void onSetPlaybackSpeed(float param1Float) {}
    
    public void onSetRating(RatingCompat param1RatingCompat) {}
    
    public void onSetRating(RatingCompat param1RatingCompat, Bundle param1Bundle) {}
    
    public void onSetRepeatMode(int param1Int) {}
    
    public void onSetShuffleMode(int param1Int) {}
    
    public void onSkipToNext() {}
    
    public void onSkipToPrevious() {}
    
    public void onSkipToQueueItem(long param1Long) {}
    
    public void onStop() {}
    
    void setSessionImpl(MediaSessionCompat.MediaSessionImpl param1MediaSessionImpl, Handler param1Handler) {
      CallbackHandler callbackHandler2;
      synchronized (this.mLock) {
        this.mSessionImpl = new WeakReference<MediaSessionCompat.MediaSessionImpl>(param1MediaSessionImpl);
        CallbackHandler callbackHandler = this.mCallbackHandler;
        callbackHandler2 = null;
        if (callbackHandler != null)
          callbackHandler.removeCallbacksAndMessages(null); 
      } 
      CallbackHandler callbackHandler1 = callbackHandler2;
      if (param1MediaSessionImpl != null)
        if (param1Handler == null) {
          callbackHandler1 = callbackHandler2;
        } else {
          callbackHandler1 = new CallbackHandler(param1Handler.getLooper());
        }  
      this.mCallbackHandler = callbackHandler1;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
    }
    
    private class CallbackHandler extends Handler {
      private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
      
      CallbackHandler(Looper param2Looper) {
        super(param2Looper);
      }
      
      public void handleMessage(Message param2Message) {
        if (param2Message.what == 1)
          synchronized (MediaSessionCompat.Callback.this.mLock) {
            MediaSessionCompat.MediaSessionImpl mediaSessionImpl = MediaSessionCompat.Callback.this.mSessionImpl.get();
            CallbackHandler callbackHandler = MediaSessionCompat.Callback.this.mCallbackHandler;
            if (mediaSessionImpl != null && MediaSessionCompat.Callback.this == mediaSessionImpl.getCallback()) {
              if (callbackHandler == null)
                return; 
              mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo)param2Message.obj);
              MediaSessionCompat.Callback.this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
              mediaSessionImpl.setCurrentControllerInfo(null);
              return;
            } 
            return;
          }  
      }
    }
    
    private class MediaSessionCallbackApi21 extends MediaSession.Callback {
      private void clearCurrentControllerInfo(MediaSessionCompat.MediaSessionImpl param2MediaSessionImpl) {
        param2MediaSessionImpl.setCurrentControllerInfo(null);
      }
      
      private MediaSessionCompat.MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
        synchronized (MediaSessionCompat.Callback.this.mLock) {
          MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionCompat.MediaSessionImplApi21)MediaSessionCompat.Callback.this.mSessionImpl.get();
          return (MediaSessionCompat.Callback.this == mediaSessionImplApi21.getCallback()) ? mediaSessionImplApi21 : null;
        } 
      }
      
      private void setCurrentControllerInfo(MediaSessionCompat.MediaSessionImpl param2MediaSessionImpl) {
        if (Build.VERSION.SDK_INT >= 28)
          return; 
        String str2 = param2MediaSessionImpl.getCallingPackage();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = v416f9e89.xbd520268("377"); 
        param2MediaSessionImpl.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(str1, -1, -1));
      }
      
      public void onCommand(String param2String, Bundle param2Bundle, ResultReceiver param2ResultReceiver) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        try {
          IBinder iBinder;
          boolean bool = param2String.equals(v416f9e89.xbd520268("378"));
          MediaSessionCompat.Token token = null;
          IMediaSession iMediaSession = null;
          if (bool) {
            param2Bundle = new Bundle();
            token = mediaSessionImplApi21.getSessionToken();
            IMediaSession iMediaSession1 = token.getExtraBinder();
            String str = v416f9e89.xbd520268("379");
            if (iMediaSession1 == null) {
              iMediaSession1 = iMediaSession;
            } else {
              iBinder = iMediaSession1.asBinder();
            } 
            BundleCompat.putBinder(param2Bundle, str, iBinder);
            ParcelUtils.putVersionedParcelable(param2Bundle, v416f9e89.xbd520268("380"), token.getSession2Token());
            param2ResultReceiver.send(0, param2Bundle);
          } else {
            bool = iBinder.equals(v416f9e89.xbd520268("381"));
            String str = v416f9e89.xbd520268("382");
            if (bool) {
              MediaSessionCompat.Callback.this.onAddQueueItem((MediaDescriptionCompat)param2Bundle.getParcelable(str));
            } else {
              bool = iBinder.equals(v416f9e89.xbd520268("383"));
              String str1 = v416f9e89.xbd520268("384");
              if (bool) {
                MediaSessionCompat.Callback.this.onAddQueueItem((MediaDescriptionCompat)param2Bundle.getParcelable(str), param2Bundle.getInt(str1));
              } else if (iBinder.equals(v416f9e89.xbd520268("385"))) {
                MediaSessionCompat.Callback.this.onRemoveQueueItem((MediaDescriptionCompat)param2Bundle.getParcelable(str));
              } else {
                MediaSessionCompat.QueueItem queueItem;
                if (iBinder.equals(v416f9e89.xbd520268("386"))) {
                  if (mediaSessionImplApi21.mQueue != null) {
                    int i = param2Bundle.getInt(str1, -1);
                    MediaSessionCompat.Token token1 = token;
                    if (i >= 0) {
                      token1 = token;
                      if (i < mediaSessionImplApi21.mQueue.size())
                        queueItem = mediaSessionImplApi21.mQueue.get(i); 
                    } 
                    if (queueItem != null)
                      MediaSessionCompat.Callback.this.onRemoveQueueItem(queueItem.getDescription()); 
                  } 
                } else {
                  MediaSessionCompat.Callback.this.onCommand((String)queueItem, param2Bundle, param2ResultReceiver);
                } 
              } 
            } 
          } 
        } catch (BadParcelableException badParcelableException) {
          Log.e(v416f9e89.xbd520268("387"), v416f9e89.xbd520268("388"));
        } 
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onCustomAction(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        try {
          Uri uri;
          boolean bool = param2String.equals(v416f9e89.xbd520268("389"));
          String str2 = v416f9e89.xbd520268("390");
          String str1 = v416f9e89.xbd520268("391");
          if (bool) {
            uri = (Uri)param2Bundle.getParcelable(str2);
            param2Bundle = param2Bundle.getBundle(str1);
            MediaSessionCompat.ensureClassLoader(param2Bundle);
            MediaSessionCompat.Callback.this.onPlayFromUri(uri, param2Bundle);
          } else if (uri.equals(v416f9e89.xbd520268("392"))) {
            MediaSessionCompat.Callback.this.onPrepare();
          } else {
            String str;
            if (uri.equals(v416f9e89.xbd520268("393"))) {
              str = param2Bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
              param2Bundle = param2Bundle.getBundle(str1);
              MediaSessionCompat.ensureClassLoader(param2Bundle);
              MediaSessionCompat.Callback.this.onPrepareFromMediaId(str, param2Bundle);
            } else if (str.equals(v416f9e89.xbd520268("394"))) {
              str = param2Bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
              param2Bundle = param2Bundle.getBundle(str1);
              MediaSessionCompat.ensureClassLoader(param2Bundle);
              MediaSessionCompat.Callback.this.onPrepareFromSearch(str, param2Bundle);
            } else {
              Uri uri1;
              if (str.equals(v416f9e89.xbd520268("395"))) {
                uri1 = (Uri)param2Bundle.getParcelable(str2);
                param2Bundle = param2Bundle.getBundle(str1);
                MediaSessionCompat.ensureClassLoader(param2Bundle);
                MediaSessionCompat.Callback.this.onPrepareFromUri(uri1, param2Bundle);
              } else if (uri1.equals(v416f9e89.xbd520268("396"))) {
                bool = param2Bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                MediaSessionCompat.Callback.this.onSetCaptioningEnabled(bool);
              } else if (uri1.equals(v416f9e89.xbd520268("397"))) {
                int i = param2Bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                MediaSessionCompat.Callback.this.onSetRepeatMode(i);
              } else if (uri1.equals(v416f9e89.xbd520268("398"))) {
                int i = param2Bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                MediaSessionCompat.Callback.this.onSetShuffleMode(i);
              } else {
                RatingCompat ratingCompat;
                if (uri1.equals(v416f9e89.xbd520268("399"))) {
                  ratingCompat = (RatingCompat)param2Bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                  param2Bundle = param2Bundle.getBundle(str1);
                  MediaSessionCompat.ensureClassLoader(param2Bundle);
                  MediaSessionCompat.Callback.this.onSetRating(ratingCompat, param2Bundle);
                } else if (ratingCompat.equals(v416f9e89.xbd520268("400"))) {
                  float f = param2Bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0F);
                  MediaSessionCompat.Callback.this.onSetPlaybackSpeed(f);
                } else {
                  MediaSessionCompat.Callback.this.onCustomAction((String)ratingCompat, param2Bundle);
                } 
              } 
            } 
          } 
        } catch (BadParcelableException badParcelableException) {
          Log.e(v416f9e89.xbd520268("401"), v416f9e89.xbd520268("402"));
        } 
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onFastForward() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onFastForward();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public boolean onMediaButtonEvent(Intent param2Intent) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        boolean bool = false;
        if (mediaSessionImplApi21 == null)
          return false; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        boolean bool1 = MediaSessionCompat.Callback.this.onMediaButtonEvent(param2Intent);
        clearCurrentControllerInfo(mediaSessionImplApi21);
        if (bool1 || super.onMediaButtonEvent(param2Intent))
          bool = true; 
        return bool;
      }
      
      public void onPause() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPause();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPlay() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPlay();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPlayFromMediaId(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPlayFromMediaId(param2String, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPlayFromSearch(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPlayFromSearch(param2String, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPlayFromUri(Uri param2Uri, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPlayFromUri(param2Uri, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPrepare() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPrepare();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPrepareFromMediaId(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPrepareFromMediaId(param2String, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPrepareFromSearch(String param2String, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPrepareFromSearch(param2String, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onPrepareFromUri(Uri param2Uri, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        MediaSessionCompat.ensureClassLoader(param2Bundle);
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onPrepareFromUri(param2Uri, param2Bundle);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onRewind() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onRewind();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSeekTo(long param2Long) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSeekTo(param2Long);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSetPlaybackSpeed(float param2Float) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSetPlaybackSpeed(param2Float);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSetRating(Rating param2Rating) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSetRating(RatingCompat.fromRating(param2Rating));
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSetRating(Rating param2Rating, Bundle param2Bundle) {}
      
      public void onSkipToNext() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSkipToNext();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSkipToPrevious() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSkipToPrevious();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onSkipToQueueItem(long param2Long) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onSkipToQueueItem(param2Long);
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
      
      public void onStop() {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
        if (mediaSessionImplApi21 == null)
          return; 
        setCurrentControllerInfo(mediaSessionImplApi21);
        MediaSessionCompat.Callback.this.onStop();
        clearCurrentControllerInfo(mediaSessionImplApi21);
      }
    }
  }
  
  private class CallbackHandler extends Handler {
    private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
    
    CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what == 1)
        synchronized (this.this$0.mLock) {
          MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.this$0.mSessionImpl.get();
          CallbackHandler callbackHandler = this.this$0.mCallbackHandler;
          if (mediaSessionImpl != null && this.this$0 == mediaSessionImpl.getCallback()) {
            if (callbackHandler == null)
              return; 
            mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo)param1Message.obj);
            this.this$0.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
            mediaSessionImpl.setCurrentControllerInfo(null);
            return;
          } 
          return;
        }  
    }
  }
  
  private class MediaSessionCallbackApi21 extends MediaSession.Callback {
    private void clearCurrentControllerInfo(MediaSessionCompat.MediaSessionImpl param1MediaSessionImpl) {
      param1MediaSessionImpl.setCurrentControllerInfo(null);
    }
    
    private MediaSessionCompat.MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
      synchronized (this.this$0.mLock) {
        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionCompat.MediaSessionImplApi21)this.this$0.mSessionImpl.get();
        return (this.this$0 == mediaSessionImplApi21.getCallback()) ? mediaSessionImplApi21 : null;
      } 
    }
    
    private void setCurrentControllerInfo(MediaSessionCompat.MediaSessionImpl param1MediaSessionImpl) {
      if (Build.VERSION.SDK_INT >= 28)
        return; 
      String str2 = param1MediaSessionImpl.getCallingPackage();
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = v416f9e89.xbd520268("377"); 
      param1MediaSessionImpl.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(str1, -1, -1));
    }
    
    public void onCommand(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      try {
        IBinder iBinder;
        boolean bool = param1String.equals(v416f9e89.xbd520268("378"));
        MediaSessionCompat.Token token = null;
        IMediaSession iMediaSession = null;
        if (bool) {
          param1Bundle = new Bundle();
          token = mediaSessionImplApi21.getSessionToken();
          IMediaSession iMediaSession1 = token.getExtraBinder();
          String str = v416f9e89.xbd520268("379");
          if (iMediaSession1 == null) {
            iMediaSession1 = iMediaSession;
          } else {
            iBinder = iMediaSession1.asBinder();
          } 
          BundleCompat.putBinder(param1Bundle, str, iBinder);
          ParcelUtils.putVersionedParcelable(param1Bundle, v416f9e89.xbd520268("380"), token.getSession2Token());
          param1ResultReceiver.send(0, param1Bundle);
        } else {
          bool = iBinder.equals(v416f9e89.xbd520268("381"));
          String str = v416f9e89.xbd520268("382");
          if (bool) {
            this.this$0.onAddQueueItem((MediaDescriptionCompat)param1Bundle.getParcelable(str));
          } else {
            bool = iBinder.equals(v416f9e89.xbd520268("383"));
            String str1 = v416f9e89.xbd520268("384");
            if (bool) {
              this.this$0.onAddQueueItem((MediaDescriptionCompat)param1Bundle.getParcelable(str), param1Bundle.getInt(str1));
            } else if (iBinder.equals(v416f9e89.xbd520268("385"))) {
              this.this$0.onRemoveQueueItem((MediaDescriptionCompat)param1Bundle.getParcelable(str));
            } else {
              MediaSessionCompat.QueueItem queueItem;
              if (iBinder.equals(v416f9e89.xbd520268("386"))) {
                if (mediaSessionImplApi21.mQueue != null) {
                  int i = param1Bundle.getInt(str1, -1);
                  MediaSessionCompat.Token token1 = token;
                  if (i >= 0) {
                    token1 = token;
                    if (i < mediaSessionImplApi21.mQueue.size())
                      queueItem = mediaSessionImplApi21.mQueue.get(i); 
                  } 
                  if (queueItem != null)
                    this.this$0.onRemoveQueueItem(queueItem.getDescription()); 
                } 
              } else {
                this.this$0.onCommand((String)queueItem, param1Bundle, param1ResultReceiver);
              } 
            } 
          } 
        } 
      } catch (BadParcelableException badParcelableException) {
        Log.e(v416f9e89.xbd520268("387"), v416f9e89.xbd520268("388"));
      } 
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onCustomAction(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      try {
        Uri uri;
        boolean bool = param1String.equals(v416f9e89.xbd520268("389"));
        String str2 = v416f9e89.xbd520268("390");
        String str1 = v416f9e89.xbd520268("391");
        if (bool) {
          uri = (Uri)param1Bundle.getParcelable(str2);
          param1Bundle = param1Bundle.getBundle(str1);
          MediaSessionCompat.ensureClassLoader(param1Bundle);
          this.this$0.onPlayFromUri(uri, param1Bundle);
        } else if (uri.equals(v416f9e89.xbd520268("392"))) {
          this.this$0.onPrepare();
        } else {
          String str;
          if (uri.equals(v416f9e89.xbd520268("393"))) {
            str = param1Bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
            param1Bundle = param1Bundle.getBundle(str1);
            MediaSessionCompat.ensureClassLoader(param1Bundle);
            this.this$0.onPrepareFromMediaId(str, param1Bundle);
          } else if (str.equals(v416f9e89.xbd520268("394"))) {
            str = param1Bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
            param1Bundle = param1Bundle.getBundle(str1);
            MediaSessionCompat.ensureClassLoader(param1Bundle);
            this.this$0.onPrepareFromSearch(str, param1Bundle);
          } else {
            Uri uri1;
            if (str.equals(v416f9e89.xbd520268("395"))) {
              uri1 = (Uri)param1Bundle.getParcelable(str2);
              param1Bundle = param1Bundle.getBundle(str1);
              MediaSessionCompat.ensureClassLoader(param1Bundle);
              this.this$0.onPrepareFromUri(uri1, param1Bundle);
            } else if (uri1.equals(v416f9e89.xbd520268("396"))) {
              bool = param1Bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
              this.this$0.onSetCaptioningEnabled(bool);
            } else if (uri1.equals(v416f9e89.xbd520268("397"))) {
              int i = param1Bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
              this.this$0.onSetRepeatMode(i);
            } else if (uri1.equals(v416f9e89.xbd520268("398"))) {
              int i = param1Bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
              this.this$0.onSetShuffleMode(i);
            } else {
              RatingCompat ratingCompat;
              if (uri1.equals(v416f9e89.xbd520268("399"))) {
                ratingCompat = (RatingCompat)param1Bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                param1Bundle = param1Bundle.getBundle(str1);
                MediaSessionCompat.ensureClassLoader(param1Bundle);
                this.this$0.onSetRating(ratingCompat, param1Bundle);
              } else if (ratingCompat.equals(v416f9e89.xbd520268("400"))) {
                float f = param1Bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0F);
                this.this$0.onSetPlaybackSpeed(f);
              } else {
                this.this$0.onCustomAction((String)ratingCompat, param1Bundle);
              } 
            } 
          } 
        } 
      } catch (BadParcelableException badParcelableException) {
        Log.e(v416f9e89.xbd520268("401"), v416f9e89.xbd520268("402"));
      } 
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onFastForward() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onFastForward();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public boolean onMediaButtonEvent(Intent param1Intent) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      boolean bool = false;
      if (mediaSessionImplApi21 == null)
        return false; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      boolean bool1 = this.this$0.onMediaButtonEvent(param1Intent);
      clearCurrentControllerInfo(mediaSessionImplApi21);
      if (bool1 || super.onMediaButtonEvent(param1Intent))
        bool = true; 
      return bool;
    }
    
    public void onPause() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPause();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPlay() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPlay();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPlayFromMediaId(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPlayFromMediaId(param1String, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPlayFromSearch(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPlayFromSearch(param1String, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPlayFromUri(Uri param1Uri, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPlayFromUri(param1Uri, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPrepare() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPrepare();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPrepareFromMediaId(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPrepareFromMediaId(param1String, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPrepareFromSearch(String param1String, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPrepareFromSearch(param1String, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onPrepareFromUri(Uri param1Uri, Bundle param1Bundle) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onPrepareFromUri(param1Uri, param1Bundle);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onRewind() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onRewind();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSeekTo(long param1Long) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSeekTo(param1Long);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSetPlaybackSpeed(float param1Float) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSetPlaybackSpeed(param1Float);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSetRating(Rating param1Rating) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSetRating(RatingCompat.fromRating(param1Rating));
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSetRating(Rating param1Rating, Bundle param1Bundle) {}
    
    public void onSkipToNext() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSkipToNext();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSkipToPrevious() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSkipToPrevious();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onSkipToQueueItem(long param1Long) {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onSkipToQueueItem(param1Long);
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
    
    public void onStop() {
      MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = getSessionImplIfCallbackIsSet();
      if (mediaSessionImplApi21 == null)
        return; 
      setCurrentControllerInfo(mediaSessionImplApi21);
      this.this$0.onStop();
      clearCurrentControllerInfo(mediaSessionImplApi21);
    }
  }
  
  static interface MediaSessionImpl {
    MediaSessionCompat.Callback getCallback();
    
    String getCallingPackage();
    
    MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();
    
    Object getMediaSession();
    
    PlaybackStateCompat getPlaybackState();
    
    Object getRemoteControlClient();
    
    MediaSessionCompat.Token getSessionToken();
    
    boolean isActive();
    
    void release();
    
    void sendSessionEvent(String param1String, Bundle param1Bundle);
    
    void setActive(boolean param1Boolean);
    
    void setCallback(MediaSessionCompat.Callback param1Callback, Handler param1Handler);
    
    void setCaptioningEnabled(boolean param1Boolean);
    
    void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo);
    
    void setExtras(Bundle param1Bundle);
    
    void setFlags(int param1Int);
    
    void setMediaButtonReceiver(PendingIntent param1PendingIntent);
    
    void setMetadata(MediaMetadataCompat param1MediaMetadataCompat);
    
    void setPlaybackState(PlaybackStateCompat param1PlaybackStateCompat);
    
    void setPlaybackToLocal(int param1Int);
    
    void setPlaybackToRemote(VolumeProviderCompat param1VolumeProviderCompat);
    
    void setQueue(List<MediaSessionCompat.QueueItem> param1List);
    
    void setQueueTitle(CharSequence param1CharSequence);
    
    void setRatingType(int param1Int);
    
    void setRepeatMode(int param1Int);
    
    void setSessionActivity(PendingIntent param1PendingIntent);
    
    void setShuffleMode(int param1Int);
  }
  
  static class MediaSessionImplApi18 extends MediaSessionImplBase {
    private static boolean sIsMbrPendingIntentSupported = true;
    
    MediaSessionImplApi18(Context param1Context, String param1String, ComponentName param1ComponentName, PendingIntent param1PendingIntent, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      super(param1Context, param1String, param1ComponentName, param1PendingIntent, param1VersionedParcelable, param1Bundle);
    }
    
    int getRccTransportControlFlagsFromActions(long param1Long) {
      int j = super.getRccTransportControlFlagsFromActions(param1Long);
      int i = j;
      if ((param1Long & 0x100L) != 0L)
        i = j | 0x100; 
      return i;
    }
    
    void registerMediaButtonEventReceiver(PendingIntent param1PendingIntent, ComponentName param1ComponentName) {
      if (sIsMbrPendingIntentSupported)
        try {
          this.mAudioManager.registerMediaButtonEventReceiver(param1PendingIntent);
        } catch (NullPointerException nullPointerException) {
          Log.w(v416f9e89.xbd520268("406"), v416f9e89.xbd520268("407"));
          sIsMbrPendingIntentSupported = false;
        }  
      if (!sIsMbrPendingIntentSupported)
        super.registerMediaButtonEventReceiver(param1PendingIntent, param1ComponentName); 
    }
    
    public void setCallback(MediaSessionCompat.Callback param1Callback, Handler param1Handler) {
      super.setCallback(param1Callback, param1Handler);
      if (param1Callback == null) {
        this.mRcc.setPlaybackPositionUpdateListener(null);
        return;
      } 
      RemoteControlClient.OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener = new RemoteControlClient.OnPlaybackPositionUpdateListener() {
          public void onPlaybackPositionUpdate(long param2Long) {
            MediaSessionCompat.MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(param2Long), null);
          }
        };
      this.mRcc.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener);
    }
    
    void setRccState(PlaybackStateCompat param1PlaybackStateCompat) {
      long l2 = param1PlaybackStateCompat.getPosition();
      float f = param1PlaybackStateCompat.getPlaybackSpeed();
      long l3 = param1PlaybackStateCompat.getLastPositionUpdateTime();
      long l4 = SystemClock.elapsedRealtime();
      long l1 = l2;
      if (param1PlaybackStateCompat.getState() == 3) {
        long l = 0L;
        l1 = l2;
        if (l2 > 0L) {
          l1 = l;
          if (l3 > 0L) {
            l = l4 - l3;
            l1 = l;
            if (f > 0.0F) {
              l1 = l;
              if (f != 1.0F)
                l1 = (long)((float)l * f); 
            } 
          } 
          l1 = l2 + l1;
        } 
      } 
      this.mRcc.setPlaybackState(getRccStateFromState(param1PlaybackStateCompat.getState()), l1, f);
    }
    
    void unregisterMediaButtonEventReceiver(PendingIntent param1PendingIntent, ComponentName param1ComponentName) {
      if (sIsMbrPendingIntentSupported) {
        this.mAudioManager.unregisterMediaButtonEventReceiver(param1PendingIntent);
        return;
      } 
      super.unregisterMediaButtonEventReceiver(param1PendingIntent, param1ComponentName);
    }
  }
  
  class null implements RemoteControlClient.OnPlaybackPositionUpdateListener {
    public void onPlaybackPositionUpdate(long param1Long) {
      this.this$0.postToHandler(18, -1, -1, Long.valueOf(param1Long), null);
    }
  }
  
  static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
    MediaSessionImplApi19(Context param1Context, String param1String, ComponentName param1ComponentName, PendingIntent param1PendingIntent, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      super(param1Context, param1String, param1ComponentName, param1PendingIntent, param1VersionedParcelable, param1Bundle);
    }
    
    RemoteControlClient.MetadataEditor buildRccMetadata(Bundle param1Bundle) {
      long l;
      RemoteControlClient.MetadataEditor metadataEditor = super.buildRccMetadata(param1Bundle);
      if (this.mState == null) {
        l = 0L;
      } else {
        l = this.mState.getActions();
      } 
      if ((l & 0x80L) != 0L)
        metadataEditor.addEditableKey(268435457); 
      if (param1Bundle == null)
        return metadataEditor; 
      String str = v416f9e89.xbd520268("434");
      if (param1Bundle.containsKey(str))
        metadataEditor.putLong(8, param1Bundle.getLong(str)); 
      str = v416f9e89.xbd520268("435");
      if (param1Bundle.containsKey(str))
        metadataEditor.putObject(101, param1Bundle.getParcelable(str)); 
      str = v416f9e89.xbd520268("436");
      if (param1Bundle.containsKey(str))
        metadataEditor.putObject(268435457, param1Bundle.getParcelable(str)); 
      return metadataEditor;
    }
    
    int getRccTransportControlFlagsFromActions(long param1Long) {
      int j = super.getRccTransportControlFlagsFromActions(param1Long);
      int i = j;
      if ((param1Long & 0x80L) != 0L)
        i = j | 0x200; 
      return i;
    }
    
    public void setCallback(MediaSessionCompat.Callback param1Callback, Handler param1Handler) {
      super.setCallback(param1Callback, param1Handler);
      if (param1Callback == null) {
        this.mRcc.setMetadataUpdateListener(null);
        return;
      } 
      RemoteControlClient.OnMetadataUpdateListener onMetadataUpdateListener = new RemoteControlClient.OnMetadataUpdateListener() {
          public void onMetadataUpdate(int param2Int, Object param2Object) {
            if (param2Int == 268435457 && param2Object instanceof Rating)
              MediaSessionCompat.MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(param2Object), null); 
          }
        };
      this.mRcc.setMetadataUpdateListener(onMetadataUpdateListener);
    }
  }
  
  class null implements RemoteControlClient.OnMetadataUpdateListener {
    public void onMetadataUpdate(int param1Int, Object param1Object) {
      if (param1Int == 268435457 && param1Object instanceof Rating)
        this.this$0.postToHandler(19, -1, -1, RatingCompat.fromRating(param1Object), null); 
    }
  }
  
  static class MediaSessionImplApi21 implements MediaSessionImpl {
    MediaSessionCompat.Callback mCallback;
    
    boolean mCaptioningEnabled;
    
    boolean mDestroyed = false;
    
    final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList();
    
    final Object mLock = new Object();
    
    MediaMetadataCompat mMetadata;
    
    PlaybackStateCompat mPlaybackState;
    
    List<MediaSessionCompat.QueueItem> mQueue;
    
    int mRatingType;
    
    MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
    
    int mRepeatMode;
    
    final MediaSession mSessionFwk;
    
    Bundle mSessionInfo;
    
    int mShuffleMode;
    
    final MediaSessionCompat.Token mToken;
    
    MediaSessionImplApi21(MediaSession param1MediaSession, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      this.mSessionFwk = param1MediaSession;
      this.mToken = new MediaSessionCompat.Token(param1MediaSession.getSessionToken(), new ExtraSession(), param1VersionedParcelable);
      this.mSessionInfo = param1Bundle;
      setFlags(3);
    }
    
    MediaSessionImplApi21(Object param1Object) {
      if (param1Object instanceof MediaSession) {
        param1Object = param1Object;
        this.mSessionFwk = (MediaSession)param1Object;
        this.mToken = new MediaSessionCompat.Token(param1Object.getSessionToken(), new ExtraSession());
        this.mSessionInfo = null;
        setFlags(3);
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("487"));
    }
    
    public MediaSessionCompat.Callback getCallback() {
      synchronized (this.mLock) {
        return this.mCallback;
      } 
    }
    
    public String getCallingPackage() {
      if (Build.VERSION.SDK_INT < 24)
        return null; 
      try {
        return (String)y0bc38925.getMethod(this.mSessionFwk.getClass(), v416f9e89.xbd520268("488"), new Class[0]).invoke(this.mSessionFwk, new Object[0]);
      } catch (Exception exception) {
        Log.e(v416f9e89.xbd520268("489"), v416f9e89.xbd520268("490"), exception);
        return null;
      } 
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
      synchronized (this.mLock) {
        return this.mRemoteUserInfo;
      } 
    }
    
    public Object getMediaSession() {
      return this.mSessionFwk;
    }
    
    public PlaybackStateCompat getPlaybackState() {
      return this.mPlaybackState;
    }
    
    public Object getRemoteControlClient() {
      return null;
    }
    
    public MediaSessionCompat.Token getSessionToken() {
      return this.mToken;
    }
    
    public boolean isActive() {
      return this.mSessionFwk.isActive();
    }
    
    public void release() {
      this.mDestroyed = true;
      this.mExtraControllerCallbacks.kill();
      this.mSessionFwk.setCallback(null);
      this.mSessionFwk.release();
    }
    
    public void sendSessionEvent(String param1String, Bundle param1Bundle) {
      if (Build.VERSION.SDK_INT < 23) {
        int i = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        while (true) {
          if (i >= 0) {
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
            try {
              iMediaControllerCallback.onEvent(param1String, param1Bundle);
            } catch (RemoteException remoteException) {}
            i--;
            continue;
          } 
          this.mExtraControllerCallbacks.finishBroadcast();
          this.mSessionFwk.sendSessionEvent(param1String, param1Bundle);
          return;
        } 
      } 
      this.mSessionFwk.sendSessionEvent(param1String, param1Bundle);
    }
    
    public void setActive(boolean param1Boolean) {
      this.mSessionFwk.setActive(param1Boolean);
    }
    
    public void setCallback(MediaSessionCompat.Callback param1Callback, Handler param1Handler) {
      synchronized (this.mLock) {
        MediaSession.Callback callback;
        this.mCallback = param1Callback;
        MediaSession mediaSession = this.mSessionFwk;
        if (param1Callback == null) {
          callback = null;
        } else {
          callback = param1Callback.mCallbackFwk;
        } 
        mediaSession.setCallback(callback, param1Handler);
        if (param1Callback != null)
          param1Callback.setSessionImpl(this, param1Handler); 
        return;
      } 
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) {
      if (this.mCaptioningEnabled != param1Boolean) {
        this.mCaptioningEnabled = param1Boolean;
        int i = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        while (true) {
          if (i >= 0) {
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
            try {
              iMediaControllerCallback.onCaptioningEnabledChanged(param1Boolean);
            } catch (RemoteException remoteException) {}
            i--;
            continue;
          } 
          this.mExtraControllerCallbacks.finishBroadcast();
          return;
        } 
      } 
    }
    
    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo) {
      synchronized (this.mLock) {
        this.mRemoteUserInfo = param1RemoteUserInfo;
        return;
      } 
    }
    
    public void setExtras(Bundle param1Bundle) {
      this.mSessionFwk.setExtras(param1Bundle);
    }
    
    public void setFlags(int param1Int) {
      this.mSessionFwk.setFlags(param1Int | 0x1 | 0x2);
    }
    
    public void setMediaButtonReceiver(PendingIntent param1PendingIntent) {
      this.mSessionFwk.setMediaButtonReceiver(param1PendingIntent);
    }
    
    public void setMetadata(MediaMetadataCompat param1MediaMetadataCompat) {
      MediaMetadata mediaMetadata;
      this.mMetadata = param1MediaMetadataCompat;
      MediaSession mediaSession = this.mSessionFwk;
      if (param1MediaMetadataCompat == null) {
        param1MediaMetadataCompat = null;
      } else {
        mediaMetadata = (MediaMetadata)param1MediaMetadataCompat.getMediaMetadata();
      } 
      mediaSession.setMetadata(mediaMetadata);
    }
    
    public void setPlaybackState(PlaybackStateCompat param1PlaybackStateCompat) {
      this.mPlaybackState = param1PlaybackStateCompat;
      int i = this.mExtraControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        PlaybackState playbackState;
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onPlaybackStateChanged(param1PlaybackStateCompat);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mExtraControllerCallbacks.finishBroadcast();
        MediaSession mediaSession = this.mSessionFwk;
        if (param1PlaybackStateCompat == null) {
          param1PlaybackStateCompat = null;
        } else {
          playbackState = (PlaybackState)param1PlaybackStateCompat.getPlaybackState();
        } 
        mediaSession.setPlaybackState(playbackState);
        return;
      } 
    }
    
    public void setPlaybackToLocal(int param1Int) {
      AudioAttributes.Builder builder = new AudioAttributes.Builder();
      builder.setLegacyStreamType(param1Int);
      this.mSessionFwk.setPlaybackToLocal(builder.build());
    }
    
    public void setPlaybackToRemote(VolumeProviderCompat param1VolumeProviderCompat) {
      this.mSessionFwk.setPlaybackToRemote((VolumeProvider)param1VolumeProviderCompat.getVolumeProvider());
    }
    
    public void setQueue(List<MediaSessionCompat.QueueItem> param1List) {
      this.mQueue = param1List;
      if (param1List == null) {
        this.mSessionFwk.setQueue(null);
        return;
      } 
      ArrayList<MediaSession.QueueItem> arrayList = new ArrayList();
      Iterator<MediaSessionCompat.QueueItem> iterator = param1List.iterator();
      while (iterator.hasNext())
        arrayList.add((MediaSession.QueueItem)((MediaSessionCompat.QueueItem)iterator.next()).getQueueItem()); 
      this.mSessionFwk.setQueue(arrayList);
    }
    
    public void setQueueTitle(CharSequence param1CharSequence) {
      this.mSessionFwk.setQueueTitle(param1CharSequence);
    }
    
    public void setRatingType(int param1Int) {
      if (Build.VERSION.SDK_INT < 22) {
        this.mRatingType = param1Int;
        return;
      } 
      this.mSessionFwk.setRatingType(param1Int);
    }
    
    public void setRepeatMode(int param1Int) {
      if (this.mRepeatMode != param1Int) {
        this.mRepeatMode = param1Int;
        int i = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        while (true) {
          if (i >= 0) {
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
            try {
              iMediaControllerCallback.onRepeatModeChanged(param1Int);
            } catch (RemoteException remoteException) {}
            i--;
            continue;
          } 
          this.mExtraControllerCallbacks.finishBroadcast();
          return;
        } 
      } 
    }
    
    public void setSessionActivity(PendingIntent param1PendingIntent) {
      this.mSessionFwk.setSessionActivity(param1PendingIntent);
    }
    
    public void setShuffleMode(int param1Int) {
      if (this.mShuffleMode != param1Int) {
        this.mShuffleMode = param1Int;
        int i = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        while (true) {
          if (i >= 0) {
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(i);
            try {
              iMediaControllerCallback.onShuffleModeChanged(param1Int);
            } catch (RemoteException remoteException) {}
            i--;
            continue;
          } 
          this.mExtraControllerCallbacks.finishBroadcast();
          return;
        } 
      } 
    }
    
    class ExtraSession extends IMediaSession.Stub {
      public void addQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) {
        throw new AssertionError();
      }
      
      public void addQueueItemAt(MediaDescriptionCompat param2MediaDescriptionCompat, int param2Int) {
        throw new AssertionError();
      }
      
      public void adjustVolume(int param2Int1, int param2Int2, String param2String) {
        throw new AssertionError();
      }
      
      public void fastForward() throws RemoteException {
        throw new AssertionError();
      }
      
      public Bundle getExtras() {
        throw new AssertionError();
      }
      
      public long getFlags() {
        throw new AssertionError();
      }
      
      public PendingIntent getLaunchPendingIntent() {
        throw new AssertionError();
      }
      
      public MediaMetadataCompat getMetadata() {
        throw new AssertionError();
      }
      
      public String getPackageName() {
        throw new AssertionError();
      }
      
      public PlaybackStateCompat getPlaybackState() {
        return MediaSessionCompat.getStateWithUpdatedPosition(MediaSessionCompat.MediaSessionImplApi21.this.mPlaybackState, MediaSessionCompat.MediaSessionImplApi21.this.mMetadata);
      }
      
      public List<MediaSessionCompat.QueueItem> getQueue() {
        return null;
      }
      
      public CharSequence getQueueTitle() {
        throw new AssertionError();
      }
      
      public int getRatingType() {
        return MediaSessionCompat.MediaSessionImplApi21.this.mRatingType;
      }
      
      public int getRepeatMode() {
        return MediaSessionCompat.MediaSessionImplApi21.this.mRepeatMode;
      }
      
      public Bundle getSessionInfo() {
        return (MediaSessionCompat.MediaSessionImplApi21.this.mSessionInfo == null) ? null : new Bundle(MediaSessionCompat.MediaSessionImplApi21.this.mSessionInfo);
      }
      
      public int getShuffleMode() {
        return MediaSessionCompat.MediaSessionImplApi21.this.mShuffleMode;
      }
      
      public String getTag() {
        throw new AssertionError();
      }
      
      public ParcelableVolumeInfo getVolumeAttributes() {
        throw new AssertionError();
      }
      
      public boolean isCaptioningEnabled() {
        return MediaSessionCompat.MediaSessionImplApi21.this.mCaptioningEnabled;
      }
      
      public boolean isShuffleModeEnabledRemoved() {
        return false;
      }
      
      public boolean isTransportControlEnabled() {
        throw new AssertionError();
      }
      
      public void next() throws RemoteException {
        throw new AssertionError();
      }
      
      public void pause() throws RemoteException {
        throw new AssertionError();
      }
      
      public void play() throws RemoteException {
        throw new AssertionError();
      }
      
      public void playFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void playFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void playFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void prepare() throws RemoteException {
        throw new AssertionError();
      }
      
      public void prepareFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void prepareFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void prepareFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void previous() throws RemoteException {
        throw new AssertionError();
      }
      
      public void rate(RatingCompat param2RatingCompat) throws RemoteException {
        throw new AssertionError();
      }
      
      public void rateWithExtras(RatingCompat param2RatingCompat, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public void registerCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) {
        if (!MediaSessionCompat.MediaSessionImplApi21.this.mDestroyed) {
          int i = getCallingPid();
          int j = getCallingUid();
          MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(v416f9e89.xbd520268("454"), i, j);
          MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.register(param2IMediaControllerCallback, remoteUserInfo);
        } 
      }
      
      public void removeQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) {
        throw new AssertionError();
      }
      
      public void removeQueueItemAt(int param2Int) {
        throw new AssertionError();
      }
      
      public void rewind() throws RemoteException {
        throw new AssertionError();
      }
      
      public void seekTo(long param2Long) throws RemoteException {
        throw new AssertionError();
      }
      
      public void sendCommand(String param2String, Bundle param2Bundle, MediaSessionCompat.ResultReceiverWrapper param2ResultReceiverWrapper) {
        throw new AssertionError();
      }
      
      public void sendCustomAction(String param2String, Bundle param2Bundle) throws RemoteException {
        throw new AssertionError();
      }
      
      public boolean sendMediaButton(KeyEvent param2KeyEvent) {
        throw new AssertionError();
      }
      
      public void setCaptioningEnabled(boolean param2Boolean) throws RemoteException {
        throw new AssertionError();
      }
      
      public void setPlaybackSpeed(float param2Float) throws RemoteException {
        throw new AssertionError();
      }
      
      public void setRepeatMode(int param2Int) throws RemoteException {
        throw new AssertionError();
      }
      
      public void setShuffleMode(int param2Int) throws RemoteException {
        throw new AssertionError();
      }
      
      public void setShuffleModeEnabledRemoved(boolean param2Boolean) throws RemoteException {}
      
      public void setVolumeTo(int param2Int1, int param2Int2, String param2String) {
        throw new AssertionError();
      }
      
      public void skipToQueueItem(long param2Long) {
        throw new AssertionError();
      }
      
      public void stop() throws RemoteException {
        throw new AssertionError();
      }
      
      public void unregisterCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) {
        MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(param2IMediaControllerCallback);
      }
    }
  }
  
  class ExtraSession extends IMediaSession.Stub {
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      throw new AssertionError();
    }
    
    public void addQueueItemAt(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      throw new AssertionError();
    }
    
    public void adjustVolume(int param1Int1, int param1Int2, String param1String) {
      throw new AssertionError();
    }
    
    public void fastForward() throws RemoteException {
      throw new AssertionError();
    }
    
    public Bundle getExtras() {
      throw new AssertionError();
    }
    
    public long getFlags() {
      throw new AssertionError();
    }
    
    public PendingIntent getLaunchPendingIntent() {
      throw new AssertionError();
    }
    
    public MediaMetadataCompat getMetadata() {
      throw new AssertionError();
    }
    
    public String getPackageName() {
      throw new AssertionError();
    }
    
    public PlaybackStateCompat getPlaybackState() {
      return MediaSessionCompat.getStateWithUpdatedPosition(this.this$0.mPlaybackState, this.this$0.mMetadata);
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
      return null;
    }
    
    public CharSequence getQueueTitle() {
      throw new AssertionError();
    }
    
    public int getRatingType() {
      return this.this$0.mRatingType;
    }
    
    public int getRepeatMode() {
      return this.this$0.mRepeatMode;
    }
    
    public Bundle getSessionInfo() {
      return (this.this$0.mSessionInfo == null) ? null : new Bundle(this.this$0.mSessionInfo);
    }
    
    public int getShuffleMode() {
      return this.this$0.mShuffleMode;
    }
    
    public String getTag() {
      throw new AssertionError();
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() {
      throw new AssertionError();
    }
    
    public boolean isCaptioningEnabled() {
      return this.this$0.mCaptioningEnabled;
    }
    
    public boolean isShuffleModeEnabledRemoved() {
      return false;
    }
    
    public boolean isTransportControlEnabled() {
      throw new AssertionError();
    }
    
    public void next() throws RemoteException {
      throw new AssertionError();
    }
    
    public void pause() throws RemoteException {
      throw new AssertionError();
    }
    
    public void play() throws RemoteException {
      throw new AssertionError();
    }
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void playFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void prepare() throws RemoteException {
      throw new AssertionError();
    }
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void previous() throws RemoteException {
      throw new AssertionError();
    }
    
    public void rate(RatingCompat param1RatingCompat) throws RemoteException {
      throw new AssertionError();
    }
    
    public void rateWithExtras(RatingCompat param1RatingCompat, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public void registerCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) {
      if (!this.this$0.mDestroyed) {
        int i = getCallingPid();
        int j = getCallingUid();
        MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(v416f9e89.xbd520268("454"), i, j);
        this.this$0.mExtraControllerCallbacks.register(param1IMediaControllerCallback, remoteUserInfo);
      } 
    }
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      throw new AssertionError();
    }
    
    public void removeQueueItemAt(int param1Int) {
      throw new AssertionError();
    }
    
    public void rewind() throws RemoteException {
      throw new AssertionError();
    }
    
    public void seekTo(long param1Long) throws RemoteException {
      throw new AssertionError();
    }
    
    public void sendCommand(String param1String, Bundle param1Bundle, MediaSessionCompat.ResultReceiverWrapper param1ResultReceiverWrapper) {
      throw new AssertionError();
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) throws RemoteException {
      throw new AssertionError();
    }
    
    public boolean sendMediaButton(KeyEvent param1KeyEvent) {
      throw new AssertionError();
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) throws RemoteException {
      throw new AssertionError();
    }
    
    public void setPlaybackSpeed(float param1Float) throws RemoteException {
      throw new AssertionError();
    }
    
    public void setRepeatMode(int param1Int) throws RemoteException {
      throw new AssertionError();
    }
    
    public void setShuffleMode(int param1Int) throws RemoteException {
      throw new AssertionError();
    }
    
    public void setShuffleModeEnabledRemoved(boolean param1Boolean) throws RemoteException {}
    
    public void setVolumeTo(int param1Int1, int param1Int2, String param1String) {
      throw new AssertionError();
    }
    
    public void skipToQueueItem(long param1Long) {
      throw new AssertionError();
    }
    
    public void stop() throws RemoteException {
      throw new AssertionError();
    }
    
    public void unregisterCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) {
      this.this$0.mExtraControllerCallbacks.unregister(param1IMediaControllerCallback);
    }
  }
  
  static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
    MediaSessionImplApi28(MediaSession param1MediaSession, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      super(param1MediaSession, param1VersionedParcelable, param1Bundle);
    }
    
    MediaSessionImplApi28(Object param1Object) {
      super(param1Object);
    }
    
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
      return new MediaSessionManager.RemoteUserInfo(this.mSessionFwk.getCurrentControllerInfo());
    }
    
    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo) {}
  }
  
  static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
    MediaSessionImplApi29(MediaSession param1MediaSession, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      super(param1MediaSession, param1VersionedParcelable, param1Bundle);
    }
    
    MediaSessionImplApi29(Object param1Object) {
      super(param1Object);
      this.mSessionInfo = ((MediaSession)param1Object).getController().getSessionInfo();
    }
  }
  
  static class MediaSessionImplBase implements MediaSessionImpl {
    static final int RCC_PLAYSTATE_NONE = 0;
    
    final AudioManager mAudioManager;
    
    volatile MediaSessionCompat.Callback mCallback;
    
    boolean mCaptioningEnabled;
    
    private final Context mContext;
    
    final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
    
    boolean mDestroyed = false;
    
    Bundle mExtras;
    
    int mFlags = 3;
    
    private MessageHandler mHandler;
    
    boolean mIsActive = false;
    
    int mLocalStream;
    
    final Object mLock = new Object();
    
    private final ComponentName mMediaButtonReceiverComponentName;
    
    private final PendingIntent mMediaButtonReceiverIntent;
    
    MediaMetadataCompat mMetadata;
    
    final String mPackageName;
    
    List<MediaSessionCompat.QueueItem> mQueue;
    
    CharSequence mQueueTitle;
    
    int mRatingType;
    
    final RemoteControlClient mRcc;
    
    private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
    
    int mRepeatMode;
    
    PendingIntent mSessionActivity;
    
    final Bundle mSessionInfo;
    
    int mShuffleMode;
    
    PlaybackStateCompat mState;
    
    private final MediaSessionStub mStub;
    
    final String mTag;
    
    private final MediaSessionCompat.Token mToken;
    
    private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
        public void onVolumeChanged(VolumeProviderCompat param2VolumeProviderCompat) {
          if (MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider != param2VolumeProviderCompat)
            return; 
          ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo(MediaSessionCompat.MediaSessionImplBase.this.mVolumeType, MediaSessionCompat.MediaSessionImplBase.this.mLocalStream, param2VolumeProviderCompat.getVolumeControl(), param2VolumeProviderCompat.getMaxVolume(), param2VolumeProviderCompat.getCurrentVolume());
          MediaSessionCompat.MediaSessionImplBase.this.sendVolumeInfoChanged(parcelableVolumeInfo);
        }
      };
    
    VolumeProviderCompat mVolumeProvider;
    
    int mVolumeType;
    
    public MediaSessionImplBase(Context param1Context, String param1String, ComponentName param1ComponentName, PendingIntent param1PendingIntent, VersionedParcelable param1VersionedParcelable, Bundle param1Bundle) {
      if (param1ComponentName != null) {
        this.mContext = param1Context;
        this.mPackageName = param1Context.getPackageName();
        this.mSessionInfo = param1Bundle;
        this.mAudioManager = (AudioManager)param1Context.getSystemService(v416f9e89.xbd520268("627"));
        this.mTag = param1String;
        this.mMediaButtonReceiverComponentName = param1ComponentName;
        this.mMediaButtonReceiverIntent = param1PendingIntent;
        MediaSessionStub mediaSessionStub = new MediaSessionStub();
        this.mStub = mediaSessionStub;
        this.mToken = new MediaSessionCompat.Token(mediaSessionStub, null, param1VersionedParcelable);
        this.mRatingType = 0;
        this.mVolumeType = 1;
        this.mLocalStream = 3;
        this.mRcc = new RemoteControlClient(param1PendingIntent);
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("628"));
    }
    
    private void sendCaptioningEnabled(boolean param1Boolean) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onCaptioningEnabledChanged(param1Boolean);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendEvent(String param1String, Bundle param1Bundle) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onEvent(param1String, param1Bundle);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendExtras(Bundle param1Bundle) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onExtrasChanged(param1Bundle);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendMetadata(MediaMetadataCompat param1MediaMetadataCompat) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onMetadataChanged(param1MediaMetadataCompat);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendQueue(List<MediaSessionCompat.QueueItem> param1List) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onQueueChanged(param1List);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendQueueTitle(CharSequence param1CharSequence) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onQueueTitleChanged(param1CharSequence);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendRepeatMode(int param1Int) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onRepeatModeChanged(param1Int);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendSessionDestroyed() {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onSessionDestroyed();
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        this.mControllerCallbacks.kill();
        return;
      } 
    }
    
    private void sendShuffleMode(int param1Int) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onShuffleModeChanged(param1Int);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    private void sendState(PlaybackStateCompat param1PlaybackStateCompat) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onPlaybackStateChanged(param1PlaybackStateCompat);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    void adjustVolume(int param1Int1, int param1Int2) {
      if (this.mVolumeType == 2) {
        VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
        if (volumeProviderCompat != null) {
          volumeProviderCompat.onAdjustVolume(param1Int1);
          return;
        } 
      } else {
        this.mAudioManager.adjustStreamVolume(this.mLocalStream, param1Int1, param1Int2);
      } 
    }
    
    RemoteControlClient.MetadataEditor buildRccMetadata(Bundle param1Bundle) {
      RemoteControlClient.MetadataEditor metadataEditor = this.mRcc.editMetadata(true);
      if (param1Bundle == null)
        return metadataEditor; 
      String str = v416f9e89.xbd520268("629");
      if (param1Bundle.containsKey(str)) {
        Bitmap bitmap2 = (Bitmap)param1Bundle.getParcelable(str);
        Bitmap bitmap1 = bitmap2;
        if (bitmap2 != null)
          bitmap1 = bitmap2.copy(bitmap2.getConfig(), false); 
        metadataEditor.putBitmap(100, bitmap1);
      } else {
        str = v416f9e89.xbd520268("630");
        if (param1Bundle.containsKey(str)) {
          Bitmap bitmap2 = (Bitmap)param1Bundle.getParcelable(str);
          Bitmap bitmap1 = bitmap2;
          if (bitmap2 != null)
            bitmap1 = bitmap2.copy(bitmap2.getConfig(), false); 
          metadataEditor.putBitmap(100, bitmap1);
        } 
      } 
      str = v416f9e89.xbd520268("631");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(1, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("632");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(13, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("633");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(2, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("634");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(3, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("635");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(15, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("636");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(4, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("637");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(5, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("638");
      if (param1Bundle.containsKey(str))
        metadataEditor.putLong(14, param1Bundle.getLong(str)); 
      str = v416f9e89.xbd520268("639");
      if (param1Bundle.containsKey(str))
        metadataEditor.putLong(9, param1Bundle.getLong(str)); 
      str = v416f9e89.xbd520268("640");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(6, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("641");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(7, param1Bundle.getString(str)); 
      str = v416f9e89.xbd520268("642");
      if (param1Bundle.containsKey(str))
        metadataEditor.putLong(0, param1Bundle.getLong(str)); 
      str = v416f9e89.xbd520268("643");
      if (param1Bundle.containsKey(str))
        metadataEditor.putString(11, param1Bundle.getString(str)); 
      return metadataEditor;
    }
    
    public MediaSessionCompat.Callback getCallback() {
      synchronized (this.mLock) {
        return this.mCallback;
      } 
    }
    
    public String getCallingPackage() {
      return null;
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
      synchronized (this.mLock) {
        return this.mRemoteUserInfo;
      } 
    }
    
    public Object getMediaSession() {
      return null;
    }
    
    String getPackageNameForUid(int param1Int) {
      String str2 = this.mContext.getPackageManager().getNameForUid(param1Int);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = v416f9e89.xbd520268("644"); 
      return str1;
    }
    
    public PlaybackStateCompat getPlaybackState() {
      synchronized (this.mLock) {
        return this.mState;
      } 
    }
    
    int getRccStateFromState(int param1Int) {
      switch (param1Int) {
        default:
          return -1;
        case 10:
        case 11:
          return 6;
        case 9:
          return 7;
        case 7:
          return 9;
        case 6:
        case 8:
          return 8;
        case 5:
          return 5;
        case 4:
          return 4;
        case 3:
          return 3;
        case 2:
          return 2;
        case 1:
          return 1;
        case 0:
          break;
      } 
      return 0;
    }
    
    int getRccTransportControlFlagsFromActions(long param1Long) {
      if ((0x1L & param1Long) != 0L) {
        j = 32;
      } else {
        j = 0;
      } 
      int i = j;
      if ((0x2L & param1Long) != 0L)
        i = j | 0x10; 
      int j = i;
      if ((0x4L & param1Long) != 0L)
        j = i | 0x4; 
      i = j;
      if ((0x8L & param1Long) != 0L)
        i = j | 0x2; 
      j = i;
      if ((0x10L & param1Long) != 0L)
        j = i | 0x1; 
      i = j;
      if ((0x20L & param1Long) != 0L)
        i = j | 0x80; 
      j = i;
      if ((0x40L & param1Long) != 0L)
        j = i | 0x40; 
      i = j;
      if ((param1Long & 0x200L) != 0L)
        i = j | 0x8; 
      return i;
    }
    
    public Object getRemoteControlClient() {
      return null;
    }
    
    public MediaSessionCompat.Token getSessionToken() {
      return this.mToken;
    }
    
    public boolean isActive() {
      return this.mIsActive;
    }
    
    void postToHandler(int param1Int1, int param1Int2, int param1Int3, Object param1Object, Bundle param1Bundle) {
      synchronized (this.mLock) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
          param1Object = messageHandler.obtainMessage(param1Int1, param1Int2, param1Int3, param1Object);
          Bundle bundle = new Bundle();
          param1Int1 = Binder.getCallingUid();
          bundle.putInt("data_calling_uid", param1Int1);
          bundle.putString("data_calling_pkg", getPackageNameForUid(param1Int1));
          param1Int1 = Binder.getCallingPid();
          if (param1Int1 > 0) {
            bundle.putInt("data_calling_pid", param1Int1);
          } else {
            bundle.putInt("data_calling_pid", -1);
          } 
          if (param1Bundle != null)
            bundle.putBundle("data_extras", param1Bundle); 
          param1Object.setData(bundle);
          param1Object.sendToTarget();
        } 
        return;
      } 
    }
    
    void registerMediaButtonEventReceiver(PendingIntent param1PendingIntent, ComponentName param1ComponentName) {
      this.mAudioManager.registerMediaButtonEventReceiver(param1ComponentName);
    }
    
    public void release() {
      this.mIsActive = false;
      this.mDestroyed = true;
      updateMbrAndRcc();
      sendSessionDestroyed();
      setCallback(null, null);
    }
    
    public void sendSessionEvent(String param1String, Bundle param1Bundle) {
      sendEvent(param1String, param1Bundle);
    }
    
    void sendVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) {
      int i = this.mControllerCallbacks.beginBroadcast() - 1;
      while (true) {
        if (i >= 0) {
          IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
          try {
            iMediaControllerCallback.onVolumeInfoChanged(param1ParcelableVolumeInfo);
          } catch (RemoteException remoteException) {}
          i--;
          continue;
        } 
        this.mControllerCallbacks.finishBroadcast();
        return;
      } 
    }
    
    public void setActive(boolean param1Boolean) {
      if (param1Boolean == this.mIsActive)
        return; 
      this.mIsActive = param1Boolean;
      updateMbrAndRcc();
    }
    
    public void setCallback(MediaSessionCompat.Callback param1Callback, Handler param1Handler) {
      MessageHandler messageHandler;
      synchronized (this.mLock) {
        messageHandler = this.mHandler;
        if (messageHandler != null)
          messageHandler.removeCallbacksAndMessages(null); 
      } 
      if (param1Callback == null || param1Handler == null) {
        messageHandler = null;
      } else {
        messageHandler = new MessageHandler(param1Handler.getLooper());
      } 
      this.mHandler = messageHandler;
      if (this.mCallback != param1Callback && this.mCallback != null)
        this.mCallback.setSessionImpl(null, null); 
      this.mCallback = param1Callback;
      if (this.mCallback != null)
        this.mCallback.setSessionImpl(this, param1Handler); 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) {
      if (this.mCaptioningEnabled != param1Boolean) {
        this.mCaptioningEnabled = param1Boolean;
        sendCaptioningEnabled(param1Boolean);
      } 
    }
    
    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo) {
      synchronized (this.mLock) {
        this.mRemoteUserInfo = param1RemoteUserInfo;
        return;
      } 
    }
    
    public void setExtras(Bundle param1Bundle) {
      this.mExtras = param1Bundle;
      sendExtras(param1Bundle);
    }
    
    public void setFlags(int param1Int) {
      synchronized (this.mLock) {
        this.mFlags = param1Int | 0x1 | 0x2;
        return;
      } 
    }
    
    public void setMediaButtonReceiver(PendingIntent param1PendingIntent) {}
    
    public void setMetadata(MediaMetadataCompat param1MediaMetadataCompat) {
      null = param1MediaMetadataCompat;
      if (param1MediaMetadataCompat != null)
        null = (new MediaMetadataCompat.Builder(param1MediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize)).build(); 
      synchronized (this.mLock) {
        this.mMetadata = null;
        sendMetadata(null);
        if (!this.mIsActive)
          return; 
        if (null == null) {
          null = null;
        } else {
          null = null.getBundle();
        } 
        buildRccMetadata((Bundle)null).apply();
        return;
      } 
    }
    
    public void setPlaybackState(PlaybackStateCompat param1PlaybackStateCompat) {
      synchronized (this.mLock) {
        this.mState = param1PlaybackStateCompat;
        sendState(param1PlaybackStateCompat);
        if (!this.mIsActive)
          return; 
        if (param1PlaybackStateCompat == null) {
          this.mRcc.setPlaybackState(0);
          this.mRcc.setTransportControlFlags(0);
          return;
        } 
        setRccState(param1PlaybackStateCompat);
        this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(param1PlaybackStateCompat.getActions()));
        return;
      } 
    }
    
    public void setPlaybackToLocal(int param1Int) {
      VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
      if (volumeProviderCompat != null)
        volumeProviderCompat.setCallback(null); 
      this.mLocalStream = param1Int;
      this.mVolumeType = 1;
      param1Int = this.mVolumeType;
      int i = this.mLocalStream;
      sendVolumeInfoChanged(new ParcelableVolumeInfo(param1Int, i, 2, this.mAudioManager.getStreamMaxVolume(i), this.mAudioManager.getStreamVolume(this.mLocalStream)));
    }
    
    public void setPlaybackToRemote(VolumeProviderCompat param1VolumeProviderCompat) {
      if (param1VolumeProviderCompat != null) {
        VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
        if (volumeProviderCompat != null)
          volumeProviderCompat.setCallback(null); 
        this.mVolumeType = 2;
        this.mVolumeProvider = param1VolumeProviderCompat;
        sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
        param1VolumeProviderCompat.setCallback(this.mVolumeCallback);
        return;
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("645"));
    }
    
    public void setQueue(List<MediaSessionCompat.QueueItem> param1List) {
      this.mQueue = param1List;
      sendQueue(param1List);
    }
    
    public void setQueueTitle(CharSequence param1CharSequence) {
      this.mQueueTitle = param1CharSequence;
      sendQueueTitle(param1CharSequence);
    }
    
    public void setRatingType(int param1Int) {
      this.mRatingType = param1Int;
    }
    
    void setRccState(PlaybackStateCompat param1PlaybackStateCompat) {
      this.mRcc.setPlaybackState(getRccStateFromState(param1PlaybackStateCompat.getState()));
    }
    
    public void setRepeatMode(int param1Int) {
      if (this.mRepeatMode != param1Int) {
        this.mRepeatMode = param1Int;
        sendRepeatMode(param1Int);
      } 
    }
    
    public void setSessionActivity(PendingIntent param1PendingIntent) {
      synchronized (this.mLock) {
        this.mSessionActivity = param1PendingIntent;
        return;
      } 
    }
    
    public void setShuffleMode(int param1Int) {
      if (this.mShuffleMode != param1Int) {
        this.mShuffleMode = param1Int;
        sendShuffleMode(param1Int);
      } 
    }
    
    void setVolumeTo(int param1Int1, int param1Int2) {
      if (this.mVolumeType == 2) {
        VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
        if (volumeProviderCompat != null) {
          volumeProviderCompat.onSetVolumeTo(param1Int1);
          return;
        } 
      } else {
        this.mAudioManager.setStreamVolume(this.mLocalStream, param1Int1, param1Int2);
      } 
    }
    
    void unregisterMediaButtonEventReceiver(PendingIntent param1PendingIntent, ComponentName param1ComponentName) {
      this.mAudioManager.unregisterMediaButtonEventReceiver(param1ComponentName);
    }
    
    void updateMbrAndRcc() {
      if (this.mIsActive) {
        registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
        this.mAudioManager.registerRemoteControlClient(this.mRcc);
        setMetadata(this.mMetadata);
        setPlaybackState(this.mState);
        return;
      } 
      unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
      this.mRcc.setPlaybackState(0);
      this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
    }
    
    private static final class Command {
      public final String command;
      
      public final Bundle extras;
      
      public final ResultReceiver stub;
      
      public Command(String param2String, Bundle param2Bundle, ResultReceiver param2ResultReceiver) {
        this.command = param2String;
        this.extras = param2Bundle;
        this.stub = param2ResultReceiver;
      }
    }
    
    class MediaSessionStub extends IMediaSession.Stub {
      public void addQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) {
        postToHandler(25, param2MediaDescriptionCompat);
      }
      
      public void addQueueItemAt(MediaDescriptionCompat param2MediaDescriptionCompat, int param2Int) {
        postToHandler(26, param2MediaDescriptionCompat, param2Int);
      }
      
      public void adjustVolume(int param2Int1, int param2Int2, String param2String) {
        MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(param2Int1, param2Int2);
      }
      
      public void fastForward() throws RemoteException {
        postToHandler(16);
      }
      
      public Bundle getExtras() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          return MediaSessionCompat.MediaSessionImplBase.this.mExtras;
        } 
      }
      
      public long getFlags() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          return MediaSessionCompat.MediaSessionImplBase.this.mFlags;
        } 
      }
      
      public PendingIntent getLaunchPendingIntent() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          return MediaSessionCompat.MediaSessionImplBase.this.mSessionActivity;
        } 
      }
      
      public MediaMetadataCompat getMetadata() {
        return MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
      }
      
      public String getPackageName() {
        return MediaSessionCompat.MediaSessionImplBase.this.mPackageName;
      }
      
      public PlaybackStateCompat getPlaybackState() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          PlaybackStateCompat playbackStateCompat = MediaSessionCompat.MediaSessionImplBase.this.mState;
          MediaMetadataCompat mediaMetadataCompat = MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
          return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
        } 
      }
      
      public List<MediaSessionCompat.QueueItem> getQueue() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          return MediaSessionCompat.MediaSessionImplBase.this.mQueue;
        } 
      }
      
      public CharSequence getQueueTitle() {
        return MediaSessionCompat.MediaSessionImplBase.this.mQueueTitle;
      }
      
      public int getRatingType() {
        return MediaSessionCompat.MediaSessionImplBase.this.mRatingType;
      }
      
      public int getRepeatMode() {
        return MediaSessionCompat.MediaSessionImplBase.this.mRepeatMode;
      }
      
      public Bundle getSessionInfo() {
        return (MediaSessionCompat.MediaSessionImplBase.this.mSessionInfo == null) ? null : new Bundle(MediaSessionCompat.MediaSessionImplBase.this.mSessionInfo);
      }
      
      public int getShuffleMode() {
        return MediaSessionCompat.MediaSessionImplBase.this.mShuffleMode;
      }
      
      public String getTag() {
        return MediaSessionCompat.MediaSessionImplBase.this.mTag;
      }
      
      public ParcelableVolumeInfo getVolumeAttributes() {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock) {
          int i;
          byte b;
          int j;
          int k = MediaSessionCompat.MediaSessionImplBase.this.mVolumeType;
          int m = MediaSessionCompat.MediaSessionImplBase.this.mLocalStream;
          VolumeProviderCompat volumeProviderCompat = MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider;
          if (k == 2) {
            b = volumeProviderCompat.getVolumeControl();
            i = volumeProviderCompat.getMaxVolume();
            j = volumeProviderCompat.getCurrentVolume();
          } else {
            i = MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(m);
            j = MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamVolume(m);
            b = 2;
          } 
          return new ParcelableVolumeInfo(k, m, b, i, j);
        } 
      }
      
      public boolean isCaptioningEnabled() {
        return MediaSessionCompat.MediaSessionImplBase.this.mCaptioningEnabled;
      }
      
      public boolean isShuffleModeEnabledRemoved() {
        return false;
      }
      
      public boolean isTransportControlEnabled() {
        return true;
      }
      
      public void next() throws RemoteException {
        postToHandler(14);
      }
      
      public void pause() throws RemoteException {
        postToHandler(12);
      }
      
      public void play() throws RemoteException {
        postToHandler(7);
      }
      
      public void playFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        postToHandler(8, param2String, param2Bundle);
      }
      
      public void playFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        postToHandler(9, param2String, param2Bundle);
      }
      
      public void playFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        postToHandler(10, param2Uri, param2Bundle);
      }
      
      void postToHandler(int param2Int) {
        MediaSessionCompat.MediaSessionImplBase.this.postToHandler(param2Int, 0, 0, null, null);
      }
      
      void postToHandler(int param2Int1, int param2Int2) {
        MediaSessionCompat.MediaSessionImplBase.this.postToHandler(param2Int1, param2Int2, 0, null, null);
      }
      
      void postToHandler(int param2Int, Object param2Object) {
        MediaSessionCompat.MediaSessionImplBase.this.postToHandler(param2Int, 0, 0, param2Object, null);
      }
      
      void postToHandler(int param2Int1, Object param2Object, int param2Int2) {
        MediaSessionCompat.MediaSessionImplBase.this.postToHandler(param2Int1, param2Int2, 0, param2Object, null);
      }
      
      void postToHandler(int param2Int, Object param2Object, Bundle param2Bundle) {
        MediaSessionCompat.MediaSessionImplBase.this.postToHandler(param2Int, 0, 0, param2Object, param2Bundle);
      }
      
      public void prepare() throws RemoteException {
        postToHandler(3);
      }
      
      public void prepareFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        postToHandler(4, param2String, param2Bundle);
      }
      
      public void prepareFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        postToHandler(5, param2String, param2Bundle);
      }
      
      public void prepareFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        postToHandler(6, param2Uri, param2Bundle);
      }
      
      public void previous() throws RemoteException {
        postToHandler(15);
      }
      
      public void rate(RatingCompat param2RatingCompat) throws RemoteException {
        postToHandler(19, param2RatingCompat);
      }
      
      public void rateWithExtras(RatingCompat param2RatingCompat, Bundle param2Bundle) throws RemoteException {
        postToHandler(31, param2RatingCompat, param2Bundle);
      }
      
      public void registerCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) {
        if (MediaSessionCompat.MediaSessionImplBase.this.mDestroyed)
          try {
            param2IMediaControllerCallback.onSessionDestroyed();
            return;
          } catch (Exception exception) {
            return;
          }  
        int i = getCallingUid();
        MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(MediaSessionCompat.MediaSessionImplBase.this.getPackageNameForUid(i), getCallingPid(), getCallingUid());
        MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.register((IInterface)exception, remoteUserInfo);
      }
      
      public void removeQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) {
        postToHandler(27, param2MediaDescriptionCompat);
      }
      
      public void removeQueueItemAt(int param2Int) {
        postToHandler(28, param2Int);
      }
      
      public void rewind() throws RemoteException {
        postToHandler(17);
      }
      
      public void seekTo(long param2Long) throws RemoteException {
        postToHandler(18, Long.valueOf(param2Long));
      }
      
      public void sendCommand(String param2String, Bundle param2Bundle, MediaSessionCompat.ResultReceiverWrapper param2ResultReceiverWrapper) {
        ResultReceiver resultReceiver;
        if (param2ResultReceiverWrapper == null) {
          param2ResultReceiverWrapper = null;
        } else {
          resultReceiver = param2ResultReceiverWrapper.mResultReceiver;
        } 
        postToHandler(1, new MediaSessionCompat.MediaSessionImplBase.Command(param2String, param2Bundle, resultReceiver));
      }
      
      public void sendCustomAction(String param2String, Bundle param2Bundle) throws RemoteException {
        postToHandler(20, param2String, param2Bundle);
      }
      
      public boolean sendMediaButton(KeyEvent param2KeyEvent) {
        postToHandler(21, param2KeyEvent);
        return true;
      }
      
      public void setCaptioningEnabled(boolean param2Boolean) throws RemoteException {
        postToHandler(29, Boolean.valueOf(param2Boolean));
      }
      
      public void setPlaybackSpeed(float param2Float) throws RemoteException {
        postToHandler(32, Float.valueOf(param2Float));
      }
      
      public void setRepeatMode(int param2Int) throws RemoteException {
        postToHandler(23, param2Int);
      }
      
      public void setShuffleMode(int param2Int) throws RemoteException {
        postToHandler(30, param2Int);
      }
      
      public void setShuffleModeEnabledRemoved(boolean param2Boolean) throws RemoteException {}
      
      public void setVolumeTo(int param2Int1, int param2Int2, String param2String) {
        MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(param2Int1, param2Int2);
      }
      
      public void skipToQueueItem(long param2Long) {
        postToHandler(11, Long.valueOf(param2Long));
      }
      
      public void stop() throws RemoteException {
        postToHandler(13);
      }
      
      public void unregisterCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) {
        MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.unregister(param2IMediaControllerCallback);
      }
    }
    
    class MessageHandler extends Handler {
      private static final int KEYCODE_MEDIA_PAUSE = 127;
      
      private static final int KEYCODE_MEDIA_PLAY = 126;
      
      private static final int MSG_ADD_QUEUE_ITEM = 25;
      
      private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
      
      private static final int MSG_ADJUST_VOLUME = 2;
      
      private static final int MSG_COMMAND = 1;
      
      private static final int MSG_CUSTOM_ACTION = 20;
      
      private static final int MSG_FAST_FORWARD = 16;
      
      private static final int MSG_MEDIA_BUTTON = 21;
      
      private static final int MSG_NEXT = 14;
      
      private static final int MSG_PAUSE = 12;
      
      private static final int MSG_PLAY = 7;
      
      private static final int MSG_PLAY_MEDIA_ID = 8;
      
      private static final int MSG_PLAY_SEARCH = 9;
      
      private static final int MSG_PLAY_URI = 10;
      
      private static final int MSG_PREPARE = 3;
      
      private static final int MSG_PREPARE_MEDIA_ID = 4;
      
      private static final int MSG_PREPARE_SEARCH = 5;
      
      private static final int MSG_PREPARE_URI = 6;
      
      private static final int MSG_PREVIOUS = 15;
      
      private static final int MSG_RATE = 19;
      
      private static final int MSG_RATE_EXTRA = 31;
      
      private static final int MSG_REMOVE_QUEUE_ITEM = 27;
      
      private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
      
      private static final int MSG_REWIND = 17;
      
      private static final int MSG_SEEK_TO = 18;
      
      private static final int MSG_SET_CAPTIONING_ENABLED = 29;
      
      private static final int MSG_SET_PLAYBACK_SPEED = 32;
      
      private static final int MSG_SET_REPEAT_MODE = 23;
      
      private static final int MSG_SET_SHUFFLE_MODE = 30;
      
      private static final int MSG_SET_VOLUME = 22;
      
      private static final int MSG_SKIP_TO_ITEM = 11;
      
      private static final int MSG_STOP = 13;
      
      public MessageHandler(Looper param2Looper) {
        super(param2Looper);
      }
      
      private void onMediaButtonEvent(KeyEvent param2KeyEvent, MediaSessionCompat.Callback param2Callback) {
        if (param2KeyEvent != null) {
          long l;
          if (param2KeyEvent.getAction() != 0)
            return; 
          if (MediaSessionCompat.MediaSessionImplBase.this.mState == null) {
            l = 0L;
          } else {
            l = MediaSessionCompat.MediaSessionImplBase.this.mState.getActions();
          } 
          int i = param2KeyEvent.getKeyCode();
          if (i != 79)
            if (i != 126) {
              if (i != 127) {
                switch (i) {
                  default:
                    return;
                  case 90:
                    if ((l & 0x40L) != 0L) {
                      param2Callback.onFastForward();
                      return;
                    } 
                    return;
                  case 89:
                    if ((l & 0x8L) != 0L) {
                      param2Callback.onRewind();
                      return;
                    } 
                    return;
                  case 88:
                    if ((l & 0x10L) != 0L) {
                      param2Callback.onSkipToPrevious();
                      return;
                    } 
                    return;
                  case 87:
                    if ((l & 0x20L) != 0L) {
                      param2Callback.onSkipToNext();
                      return;
                    } 
                    return;
                  case 86:
                    if ((l & 0x1L) != 0L) {
                      param2Callback.onStop();
                      return;
                    } 
                    return;
                  case 85:
                    break;
                } 
              } else {
                if ((l & 0x2L) != 0L) {
                  param2Callback.onPause();
                  return;
                } 
                return;
              } 
            } else {
              if ((l & 0x4L) != 0L) {
                param2Callback.onPlay();
                return;
              } 
              return;
            }  
          Log.w(v416f9e89.xbd520268("502"), v416f9e89.xbd520268("503"));
        } 
      }
      
      public void handleMessage(Message param2Message) {
        // Byte code:
        //   0: aload_0
        //   1: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   4: getfield mCallback : Landroid/support/v4/media/session/MediaSessionCompat$Callback;
        //   7: astore_2
        //   8: aload_2
        //   9: ifnonnull -> 13
        //   12: return
        //   13: aload_1
        //   14: invokevirtual getData : ()Landroid/os/Bundle;
        //   17: astore_3
        //   18: aload_3
        //   19: invokestatic ensureClassLoader : (Landroid/os/Bundle;)V
        //   22: aload_0
        //   23: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   26: new androidx/media/MediaSessionManager$RemoteUserInfo
        //   29: dup
        //   30: aload_3
        //   31: ldc '504'
        //   33: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   36: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
        //   39: aload_3
        //   40: ldc '505'
        //   42: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   45: invokevirtual getInt : (Ljava/lang/String;)I
        //   48: aload_3
        //   49: ldc '506'
        //   51: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   54: invokevirtual getInt : (Ljava/lang/String;)I
        //   57: invokespecial <init> : (Ljava/lang/String;II)V
        //   60: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
        //   63: aload_3
        //   64: ldc '507'
        //   66: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   69: invokevirtual getBundle : (Ljava/lang/String;)Landroid/os/Bundle;
        //   72: astore_3
        //   73: aload_3
        //   74: invokestatic ensureClassLoader : (Landroid/os/Bundle;)V
        //   77: aload_1
        //   78: getfield what : I
        //   81: tableswitch default -> 749, 1 -> 705, 2 -> 690, 3 -> 683, 4 -> 668, 5 -> 653, 6 -> 638, 7 -> 631, 8 -> 616, 9 -> 601, 10 -> 586, 11 -> 569, 12 -> 562, 13 -> 555, 14 -> 548, 15 -> 541, 16 -> 534, 17 -> 527, 18 -> 510, 19 -> 496, 20 -> 481, 21 -> 430, 22 -> 415, 23 -> 404, 24 -> 749, 25 -> 390, 26 -> 372, 27 -> 358, 28 -> 284, 29 -> 267, 30 -> 256, 31 -> 241, 32 -> 224
        //   224: aload_2
        //   225: aload_1
        //   226: getfield obj : Ljava/lang/Object;
        //   229: checkcast java/lang/Float
        //   232: invokevirtual floatValue : ()F
        //   235: invokevirtual onSetPlaybackSpeed : (F)V
        //   238: goto -> 729
        //   241: aload_2
        //   242: aload_1
        //   243: getfield obj : Ljava/lang/Object;
        //   246: checkcast android/support/v4/media/RatingCompat
        //   249: aload_3
        //   250: invokevirtual onSetRating : (Landroid/support/v4/media/RatingCompat;Landroid/os/Bundle;)V
        //   253: goto -> 729
        //   256: aload_2
        //   257: aload_1
        //   258: getfield arg1 : I
        //   261: invokevirtual onSetShuffleMode : (I)V
        //   264: goto -> 729
        //   267: aload_2
        //   268: aload_1
        //   269: getfield obj : Ljava/lang/Object;
        //   272: checkcast java/lang/Boolean
        //   275: invokevirtual booleanValue : ()Z
        //   278: invokevirtual onSetCaptioningEnabled : (Z)V
        //   281: goto -> 729
        //   284: aload_0
        //   285: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   288: getfield mQueue : Ljava/util/List;
        //   291: ifnull -> 729
        //   294: aload_1
        //   295: getfield arg1 : I
        //   298: iflt -> 752
        //   301: aload_1
        //   302: getfield arg1 : I
        //   305: aload_0
        //   306: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   309: getfield mQueue : Ljava/util/List;
        //   312: invokeinterface size : ()I
        //   317: if_icmpge -> 752
        //   320: aload_0
        //   321: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   324: getfield mQueue : Ljava/util/List;
        //   327: aload_1
        //   328: getfield arg1 : I
        //   331: invokeinterface get : (I)Ljava/lang/Object;
        //   336: checkcast android/support/v4/media/session/MediaSessionCompat$QueueItem
        //   339: astore_1
        //   340: goto -> 343
        //   343: aload_1
        //   344: ifnull -> 729
        //   347: aload_2
        //   348: aload_1
        //   349: invokevirtual getDescription : ()Landroid/support/v4/media/MediaDescriptionCompat;
        //   352: invokevirtual onRemoveQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
        //   355: goto -> 729
        //   358: aload_2
        //   359: aload_1
        //   360: getfield obj : Ljava/lang/Object;
        //   363: checkcast android/support/v4/media/MediaDescriptionCompat
        //   366: invokevirtual onRemoveQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
        //   369: goto -> 729
        //   372: aload_2
        //   373: aload_1
        //   374: getfield obj : Ljava/lang/Object;
        //   377: checkcast android/support/v4/media/MediaDescriptionCompat
        //   380: aload_1
        //   381: getfield arg1 : I
        //   384: invokevirtual onAddQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;I)V
        //   387: goto -> 729
        //   390: aload_2
        //   391: aload_1
        //   392: getfield obj : Ljava/lang/Object;
        //   395: checkcast android/support/v4/media/MediaDescriptionCompat
        //   398: invokevirtual onAddQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
        //   401: goto -> 729
        //   404: aload_2
        //   405: aload_1
        //   406: getfield arg1 : I
        //   409: invokevirtual onSetRepeatMode : (I)V
        //   412: goto -> 729
        //   415: aload_0
        //   416: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   419: aload_1
        //   420: getfield arg1 : I
        //   423: iconst_0
        //   424: invokevirtual setVolumeTo : (II)V
        //   427: goto -> 729
        //   430: aload_1
        //   431: getfield obj : Ljava/lang/Object;
        //   434: checkcast android/view/KeyEvent
        //   437: astore_1
        //   438: new android/content/Intent
        //   441: dup
        //   442: ldc_w '508'
        //   445: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   448: invokespecial <init> : (Ljava/lang/String;)V
        //   451: astore_3
        //   452: aload_3
        //   453: ldc_w '509'
        //   456: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
        //   459: aload_1
        //   460: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
        //   463: pop
        //   464: aload_2
        //   465: aload_3
        //   466: invokevirtual onMediaButtonEvent : (Landroid/content/Intent;)Z
        //   469: ifne -> 729
        //   472: aload_0
        //   473: aload_1
        //   474: aload_2
        //   475: invokespecial onMediaButtonEvent : (Landroid/view/KeyEvent;Landroid/support/v4/media/session/MediaSessionCompat$Callback;)V
        //   478: goto -> 729
        //   481: aload_2
        //   482: aload_1
        //   483: getfield obj : Ljava/lang/Object;
        //   486: checkcast java/lang/String
        //   489: aload_3
        //   490: invokevirtual onCustomAction : (Ljava/lang/String;Landroid/os/Bundle;)V
        //   493: goto -> 729
        //   496: aload_2
        //   497: aload_1
        //   498: getfield obj : Ljava/lang/Object;
        //   501: checkcast android/support/v4/media/RatingCompat
        //   504: invokevirtual onSetRating : (Landroid/support/v4/media/RatingCompat;)V
        //   507: goto -> 729
        //   510: aload_2
        //   511: aload_1
        //   512: getfield obj : Ljava/lang/Object;
        //   515: checkcast java/lang/Long
        //   518: invokevirtual longValue : ()J
        //   521: invokevirtual onSeekTo : (J)V
        //   524: goto -> 729
        //   527: aload_2
        //   528: invokevirtual onRewind : ()V
        //   531: goto -> 729
        //   534: aload_2
        //   535: invokevirtual onFastForward : ()V
        //   538: goto -> 729
        //   541: aload_2
        //   542: invokevirtual onSkipToPrevious : ()V
        //   545: goto -> 729
        //   548: aload_2
        //   549: invokevirtual onSkipToNext : ()V
        //   552: goto -> 729
        //   555: aload_2
        //   556: invokevirtual onStop : ()V
        //   559: goto -> 729
        //   562: aload_2
        //   563: invokevirtual onPause : ()V
        //   566: goto -> 729
        //   569: aload_2
        //   570: aload_1
        //   571: getfield obj : Ljava/lang/Object;
        //   574: checkcast java/lang/Long
        //   577: invokevirtual longValue : ()J
        //   580: invokevirtual onSkipToQueueItem : (J)V
        //   583: goto -> 729
        //   586: aload_2
        //   587: aload_1
        //   588: getfield obj : Ljava/lang/Object;
        //   591: checkcast android/net/Uri
        //   594: aload_3
        //   595: invokevirtual onPlayFromUri : (Landroid/net/Uri;Landroid/os/Bundle;)V
        //   598: goto -> 729
        //   601: aload_2
        //   602: aload_1
        //   603: getfield obj : Ljava/lang/Object;
        //   606: checkcast java/lang/String
        //   609: aload_3
        //   610: invokevirtual onPlayFromSearch : (Ljava/lang/String;Landroid/os/Bundle;)V
        //   613: goto -> 729
        //   616: aload_2
        //   617: aload_1
        //   618: getfield obj : Ljava/lang/Object;
        //   621: checkcast java/lang/String
        //   624: aload_3
        //   625: invokevirtual onPlayFromMediaId : (Ljava/lang/String;Landroid/os/Bundle;)V
        //   628: goto -> 729
        //   631: aload_2
        //   632: invokevirtual onPlay : ()V
        //   635: goto -> 729
        //   638: aload_2
        //   639: aload_1
        //   640: getfield obj : Ljava/lang/Object;
        //   643: checkcast android/net/Uri
        //   646: aload_3
        //   647: invokevirtual onPrepareFromUri : (Landroid/net/Uri;Landroid/os/Bundle;)V
        //   650: goto -> 729
        //   653: aload_2
        //   654: aload_1
        //   655: getfield obj : Ljava/lang/Object;
        //   658: checkcast java/lang/String
        //   661: aload_3
        //   662: invokevirtual onPrepareFromSearch : (Ljava/lang/String;Landroid/os/Bundle;)V
        //   665: goto -> 729
        //   668: aload_2
        //   669: aload_1
        //   670: getfield obj : Ljava/lang/Object;
        //   673: checkcast java/lang/String
        //   676: aload_3
        //   677: invokevirtual onPrepareFromMediaId : (Ljava/lang/String;Landroid/os/Bundle;)V
        //   680: goto -> 729
        //   683: aload_2
        //   684: invokevirtual onPrepare : ()V
        //   687: goto -> 729
        //   690: aload_0
        //   691: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   694: aload_1
        //   695: getfield arg1 : I
        //   698: iconst_0
        //   699: invokevirtual adjustVolume : (II)V
        //   702: goto -> 729
        //   705: aload_1
        //   706: getfield obj : Ljava/lang/Object;
        //   709: checkcast android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$Command
        //   712: astore_1
        //   713: aload_2
        //   714: aload_1
        //   715: getfield command : Ljava/lang/String;
        //   718: aload_1
        //   719: getfield extras : Landroid/os/Bundle;
        //   722: aload_1
        //   723: getfield stub : Landroid/os/ResultReceiver;
        //   726: invokevirtual onCommand : (Ljava/lang/String;Landroid/os/Bundle;Landroid/os/ResultReceiver;)V
        //   729: aload_0
        //   730: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   733: aconst_null
        //   734: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
        //   737: return
        //   738: astore_1
        //   739: aload_0
        //   740: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   743: aconst_null
        //   744: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
        //   747: aload_1
        //   748: athrow
        //   749: goto -> 729
        //   752: aconst_null
        //   753: astore_1
        //   754: goto -> 343
        // Exception table:
        //   from	to	target	type
        //   77	224	738	finally
        //   224	238	738	finally
        //   241	253	738	finally
        //   256	264	738	finally
        //   267	281	738	finally
        //   284	340	738	finally
        //   347	355	738	finally
        //   358	369	738	finally
        //   372	387	738	finally
        //   390	401	738	finally
        //   404	412	738	finally
        //   415	427	738	finally
        //   430	478	738	finally
        //   481	493	738	finally
        //   496	507	738	finally
        //   510	524	738	finally
        //   527	531	738	finally
        //   534	538	738	finally
        //   541	545	738	finally
        //   548	552	738	finally
        //   555	559	738	finally
        //   562	566	738	finally
        //   569	583	738	finally
        //   586	598	738	finally
        //   601	613	738	finally
        //   616	628	738	finally
        //   631	635	738	finally
        //   638	650	738	finally
        //   653	665	738	finally
        //   668	680	738	finally
        //   683	687	738	finally
        //   690	702	738	finally
        //   705	729	738	finally
      }
    }
  }
  
  class null extends VolumeProviderCompat.Callback {
    public void onVolumeChanged(VolumeProviderCompat param1VolumeProviderCompat) {
      if (this.this$0.mVolumeProvider != param1VolumeProviderCompat)
        return; 
      ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo(this.this$0.mVolumeType, this.this$0.mLocalStream, param1VolumeProviderCompat.getVolumeControl(), param1VolumeProviderCompat.getMaxVolume(), param1VolumeProviderCompat.getCurrentVolume());
      this.this$0.sendVolumeInfoChanged(parcelableVolumeInfo);
    }
  }
  
  private static final class Command {
    public final String command;
    
    public final Bundle extras;
    
    public final ResultReceiver stub;
    
    public Command(String param1String, Bundle param1Bundle, ResultReceiver param1ResultReceiver) {
      this.command = param1String;
      this.extras = param1Bundle;
      this.stub = param1ResultReceiver;
    }
  }
  
  class MediaSessionStub extends IMediaSession.Stub {
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      postToHandler(25, param1MediaDescriptionCompat);
    }
    
    public void addQueueItemAt(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) {
      postToHandler(26, param1MediaDescriptionCompat, param1Int);
    }
    
    public void adjustVolume(int param1Int1, int param1Int2, String param1String) {
      this.this$0.adjustVolume(param1Int1, param1Int2);
    }
    
    public void fastForward() throws RemoteException {
      postToHandler(16);
    }
    
    public Bundle getExtras() {
      synchronized (this.this$0.mLock) {
        return this.this$0.mExtras;
      } 
    }
    
    public long getFlags() {
      synchronized (this.this$0.mLock) {
        return this.this$0.mFlags;
      } 
    }
    
    public PendingIntent getLaunchPendingIntent() {
      synchronized (this.this$0.mLock) {
        return this.this$0.mSessionActivity;
      } 
    }
    
    public MediaMetadataCompat getMetadata() {
      return this.this$0.mMetadata;
    }
    
    public String getPackageName() {
      return this.this$0.mPackageName;
    }
    
    public PlaybackStateCompat getPlaybackState() {
      synchronized (this.this$0.mLock) {
        PlaybackStateCompat playbackStateCompat = this.this$0.mState;
        MediaMetadataCompat mediaMetadataCompat = this.this$0.mMetadata;
        return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
      } 
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
      synchronized (this.this$0.mLock) {
        return this.this$0.mQueue;
      } 
    }
    
    public CharSequence getQueueTitle() {
      return this.this$0.mQueueTitle;
    }
    
    public int getRatingType() {
      return this.this$0.mRatingType;
    }
    
    public int getRepeatMode() {
      return this.this$0.mRepeatMode;
    }
    
    public Bundle getSessionInfo() {
      return (this.this$0.mSessionInfo == null) ? null : new Bundle(this.this$0.mSessionInfo);
    }
    
    public int getShuffleMode() {
      return this.this$0.mShuffleMode;
    }
    
    public String getTag() {
      return this.this$0.mTag;
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() {
      synchronized (this.this$0.mLock) {
        int i;
        byte b;
        int j;
        int k = this.this$0.mVolumeType;
        int m = this.this$0.mLocalStream;
        VolumeProviderCompat volumeProviderCompat = this.this$0.mVolumeProvider;
        if (k == 2) {
          b = volumeProviderCompat.getVolumeControl();
          i = volumeProviderCompat.getMaxVolume();
          j = volumeProviderCompat.getCurrentVolume();
        } else {
          i = this.this$0.mAudioManager.getStreamMaxVolume(m);
          j = this.this$0.mAudioManager.getStreamVolume(m);
          b = 2;
        } 
        return new ParcelableVolumeInfo(k, m, b, i, j);
      } 
    }
    
    public boolean isCaptioningEnabled() {
      return this.this$0.mCaptioningEnabled;
    }
    
    public boolean isShuffleModeEnabledRemoved() {
      return false;
    }
    
    public boolean isTransportControlEnabled() {
      return true;
    }
    
    public void next() throws RemoteException {
      postToHandler(14);
    }
    
    public void pause() throws RemoteException {
      postToHandler(12);
    }
    
    public void play() throws RemoteException {
      postToHandler(7);
    }
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      postToHandler(8, param1String, param1Bundle);
    }
    
    public void playFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      postToHandler(9, param1String, param1Bundle);
    }
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      postToHandler(10, param1Uri, param1Bundle);
    }
    
    void postToHandler(int param1Int) {
      this.this$0.postToHandler(param1Int, 0, 0, null, null);
    }
    
    void postToHandler(int param1Int1, int param1Int2) {
      this.this$0.postToHandler(param1Int1, param1Int2, 0, null, null);
    }
    
    void postToHandler(int param1Int, Object param1Object) {
      this.this$0.postToHandler(param1Int, 0, 0, param1Object, null);
    }
    
    void postToHandler(int param1Int1, Object param1Object, int param1Int2) {
      this.this$0.postToHandler(param1Int1, param1Int2, 0, param1Object, null);
    }
    
    void postToHandler(int param1Int, Object param1Object, Bundle param1Bundle) {
      this.this$0.postToHandler(param1Int, 0, 0, param1Object, param1Bundle);
    }
    
    public void prepare() throws RemoteException {
      postToHandler(3);
    }
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      postToHandler(4, param1String, param1Bundle);
    }
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      postToHandler(5, param1String, param1Bundle);
    }
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      postToHandler(6, param1Uri, param1Bundle);
    }
    
    public void previous() throws RemoteException {
      postToHandler(15);
    }
    
    public void rate(RatingCompat param1RatingCompat) throws RemoteException {
      postToHandler(19, param1RatingCompat);
    }
    
    public void rateWithExtras(RatingCompat param1RatingCompat, Bundle param1Bundle) throws RemoteException {
      postToHandler(31, param1RatingCompat, param1Bundle);
    }
    
    public void registerCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) {
      if (this.this$0.mDestroyed)
        try {
          param1IMediaControllerCallback.onSessionDestroyed();
          return;
        } catch (Exception exception) {
          return;
        }  
      int i = getCallingUid();
      MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(this.this$0.getPackageNameForUid(i), getCallingPid(), getCallingUid());
      this.this$0.mControllerCallbacks.register((IInterface)exception, remoteUserInfo);
    }
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) {
      postToHandler(27, param1MediaDescriptionCompat);
    }
    
    public void removeQueueItemAt(int param1Int) {
      postToHandler(28, param1Int);
    }
    
    public void rewind() throws RemoteException {
      postToHandler(17);
    }
    
    public void seekTo(long param1Long) throws RemoteException {
      postToHandler(18, Long.valueOf(param1Long));
    }
    
    public void sendCommand(String param1String, Bundle param1Bundle, MediaSessionCompat.ResultReceiverWrapper param1ResultReceiverWrapper) {
      ResultReceiver resultReceiver;
      if (param1ResultReceiverWrapper == null) {
        param1ResultReceiverWrapper = null;
      } else {
        resultReceiver = param1ResultReceiverWrapper.mResultReceiver;
      } 
      postToHandler(1, new MediaSessionCompat.MediaSessionImplBase.Command(param1String, param1Bundle, resultReceiver));
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) throws RemoteException {
      postToHandler(20, param1String, param1Bundle);
    }
    
    public boolean sendMediaButton(KeyEvent param1KeyEvent) {
      postToHandler(21, param1KeyEvent);
      return true;
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) throws RemoteException {
      postToHandler(29, Boolean.valueOf(param1Boolean));
    }
    
    public void setPlaybackSpeed(float param1Float) throws RemoteException {
      postToHandler(32, Float.valueOf(param1Float));
    }
    
    public void setRepeatMode(int param1Int) throws RemoteException {
      postToHandler(23, param1Int);
    }
    
    public void setShuffleMode(int param1Int) throws RemoteException {
      postToHandler(30, param1Int);
    }
    
    public void setShuffleModeEnabledRemoved(boolean param1Boolean) throws RemoteException {}
    
    public void setVolumeTo(int param1Int1, int param1Int2, String param1String) {
      this.this$0.setVolumeTo(param1Int1, param1Int2);
    }
    
    public void skipToQueueItem(long param1Long) {
      postToHandler(11, Long.valueOf(param1Long));
    }
    
    public void stop() throws RemoteException {
      postToHandler(13);
    }
    
    public void unregisterCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) {
      this.this$0.mControllerCallbacks.unregister(param1IMediaControllerCallback);
    }
  }
  
  class MessageHandler extends Handler {
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    
    private static final int KEYCODE_MEDIA_PLAY = 126;
    
    private static final int MSG_ADD_QUEUE_ITEM = 25;
    
    private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
    
    private static final int MSG_ADJUST_VOLUME = 2;
    
    private static final int MSG_COMMAND = 1;
    
    private static final int MSG_CUSTOM_ACTION = 20;
    
    private static final int MSG_FAST_FORWARD = 16;
    
    private static final int MSG_MEDIA_BUTTON = 21;
    
    private static final int MSG_NEXT = 14;
    
    private static final int MSG_PAUSE = 12;
    
    private static final int MSG_PLAY = 7;
    
    private static final int MSG_PLAY_MEDIA_ID = 8;
    
    private static final int MSG_PLAY_SEARCH = 9;
    
    private static final int MSG_PLAY_URI = 10;
    
    private static final int MSG_PREPARE = 3;
    
    private static final int MSG_PREPARE_MEDIA_ID = 4;
    
    private static final int MSG_PREPARE_SEARCH = 5;
    
    private static final int MSG_PREPARE_URI = 6;
    
    private static final int MSG_PREVIOUS = 15;
    
    private static final int MSG_RATE = 19;
    
    private static final int MSG_RATE_EXTRA = 31;
    
    private static final int MSG_REMOVE_QUEUE_ITEM = 27;
    
    private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
    
    private static final int MSG_REWIND = 17;
    
    private static final int MSG_SEEK_TO = 18;
    
    private static final int MSG_SET_CAPTIONING_ENABLED = 29;
    
    private static final int MSG_SET_PLAYBACK_SPEED = 32;
    
    private static final int MSG_SET_REPEAT_MODE = 23;
    
    private static final int MSG_SET_SHUFFLE_MODE = 30;
    
    private static final int MSG_SET_VOLUME = 22;
    
    private static final int MSG_SKIP_TO_ITEM = 11;
    
    private static final int MSG_STOP = 13;
    
    public MessageHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    private void onMediaButtonEvent(KeyEvent param1KeyEvent, MediaSessionCompat.Callback param1Callback) {
      if (param1KeyEvent != null) {
        long l;
        if (param1KeyEvent.getAction() != 0)
          return; 
        if (this.this$0.mState == null) {
          l = 0L;
        } else {
          l = this.this$0.mState.getActions();
        } 
        int i = param1KeyEvent.getKeyCode();
        if (i != 79)
          if (i != 126) {
            if (i != 127) {
              switch (i) {
                default:
                  return;
                case 90:
                  if ((l & 0x40L) != 0L) {
                    param1Callback.onFastForward();
                    return;
                  } 
                  return;
                case 89:
                  if ((l & 0x8L) != 0L) {
                    param1Callback.onRewind();
                    return;
                  } 
                  return;
                case 88:
                  if ((l & 0x10L) != 0L) {
                    param1Callback.onSkipToPrevious();
                    return;
                  } 
                  return;
                case 87:
                  if ((l & 0x20L) != 0L) {
                    param1Callback.onSkipToNext();
                    return;
                  } 
                  return;
                case 86:
                  if ((l & 0x1L) != 0L) {
                    param1Callback.onStop();
                    return;
                  } 
                  return;
                case 85:
                  break;
              } 
            } else {
              if ((l & 0x2L) != 0L) {
                param1Callback.onPause();
                return;
              } 
              return;
            } 
          } else {
            if ((l & 0x4L) != 0L) {
              param1Callback.onPlay();
              return;
            } 
            return;
          }  
        Log.w(v416f9e89.xbd520268("502"), v416f9e89.xbd520268("503"));
      } 
    }
    
    public void handleMessage(Message param1Message) {
      // Byte code:
      //   0: aload_0
      //   1: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   4: getfield mCallback : Landroid/support/v4/media/session/MediaSessionCompat$Callback;
      //   7: astore_2
      //   8: aload_2
      //   9: ifnonnull -> 13
      //   12: return
      //   13: aload_1
      //   14: invokevirtual getData : ()Landroid/os/Bundle;
      //   17: astore_3
      //   18: aload_3
      //   19: invokestatic ensureClassLoader : (Landroid/os/Bundle;)V
      //   22: aload_0
      //   23: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   26: new androidx/media/MediaSessionManager$RemoteUserInfo
      //   29: dup
      //   30: aload_3
      //   31: ldc '504'
      //   33: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   36: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
      //   39: aload_3
      //   40: ldc '505'
      //   42: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   45: invokevirtual getInt : (Ljava/lang/String;)I
      //   48: aload_3
      //   49: ldc '506'
      //   51: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   54: invokevirtual getInt : (Ljava/lang/String;)I
      //   57: invokespecial <init> : (Ljava/lang/String;II)V
      //   60: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
      //   63: aload_3
      //   64: ldc '507'
      //   66: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   69: invokevirtual getBundle : (Ljava/lang/String;)Landroid/os/Bundle;
      //   72: astore_3
      //   73: aload_3
      //   74: invokestatic ensureClassLoader : (Landroid/os/Bundle;)V
      //   77: aload_1
      //   78: getfield what : I
      //   81: tableswitch default -> 749, 1 -> 705, 2 -> 690, 3 -> 683, 4 -> 668, 5 -> 653, 6 -> 638, 7 -> 631, 8 -> 616, 9 -> 601, 10 -> 586, 11 -> 569, 12 -> 562, 13 -> 555, 14 -> 548, 15 -> 541, 16 -> 534, 17 -> 527, 18 -> 510, 19 -> 496, 20 -> 481, 21 -> 430, 22 -> 415, 23 -> 404, 24 -> 749, 25 -> 390, 26 -> 372, 27 -> 358, 28 -> 284, 29 -> 267, 30 -> 256, 31 -> 241, 32 -> 224
      //   224: aload_2
      //   225: aload_1
      //   226: getfield obj : Ljava/lang/Object;
      //   229: checkcast java/lang/Float
      //   232: invokevirtual floatValue : ()F
      //   235: invokevirtual onSetPlaybackSpeed : (F)V
      //   238: goto -> 729
      //   241: aload_2
      //   242: aload_1
      //   243: getfield obj : Ljava/lang/Object;
      //   246: checkcast android/support/v4/media/RatingCompat
      //   249: aload_3
      //   250: invokevirtual onSetRating : (Landroid/support/v4/media/RatingCompat;Landroid/os/Bundle;)V
      //   253: goto -> 729
      //   256: aload_2
      //   257: aload_1
      //   258: getfield arg1 : I
      //   261: invokevirtual onSetShuffleMode : (I)V
      //   264: goto -> 729
      //   267: aload_2
      //   268: aload_1
      //   269: getfield obj : Ljava/lang/Object;
      //   272: checkcast java/lang/Boolean
      //   275: invokevirtual booleanValue : ()Z
      //   278: invokevirtual onSetCaptioningEnabled : (Z)V
      //   281: goto -> 729
      //   284: aload_0
      //   285: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   288: getfield mQueue : Ljava/util/List;
      //   291: ifnull -> 729
      //   294: aload_1
      //   295: getfield arg1 : I
      //   298: iflt -> 752
      //   301: aload_1
      //   302: getfield arg1 : I
      //   305: aload_0
      //   306: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   309: getfield mQueue : Ljava/util/List;
      //   312: invokeinterface size : ()I
      //   317: if_icmpge -> 752
      //   320: aload_0
      //   321: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   324: getfield mQueue : Ljava/util/List;
      //   327: aload_1
      //   328: getfield arg1 : I
      //   331: invokeinterface get : (I)Ljava/lang/Object;
      //   336: checkcast android/support/v4/media/session/MediaSessionCompat$QueueItem
      //   339: astore_1
      //   340: goto -> 343
      //   343: aload_1
      //   344: ifnull -> 729
      //   347: aload_2
      //   348: aload_1
      //   349: invokevirtual getDescription : ()Landroid/support/v4/media/MediaDescriptionCompat;
      //   352: invokevirtual onRemoveQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
      //   355: goto -> 729
      //   358: aload_2
      //   359: aload_1
      //   360: getfield obj : Ljava/lang/Object;
      //   363: checkcast android/support/v4/media/MediaDescriptionCompat
      //   366: invokevirtual onRemoveQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
      //   369: goto -> 729
      //   372: aload_2
      //   373: aload_1
      //   374: getfield obj : Ljava/lang/Object;
      //   377: checkcast android/support/v4/media/MediaDescriptionCompat
      //   380: aload_1
      //   381: getfield arg1 : I
      //   384: invokevirtual onAddQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;I)V
      //   387: goto -> 729
      //   390: aload_2
      //   391: aload_1
      //   392: getfield obj : Ljava/lang/Object;
      //   395: checkcast android/support/v4/media/MediaDescriptionCompat
      //   398: invokevirtual onAddQueueItem : (Landroid/support/v4/media/MediaDescriptionCompat;)V
      //   401: goto -> 729
      //   404: aload_2
      //   405: aload_1
      //   406: getfield arg1 : I
      //   409: invokevirtual onSetRepeatMode : (I)V
      //   412: goto -> 729
      //   415: aload_0
      //   416: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   419: aload_1
      //   420: getfield arg1 : I
      //   423: iconst_0
      //   424: invokevirtual setVolumeTo : (II)V
      //   427: goto -> 729
      //   430: aload_1
      //   431: getfield obj : Ljava/lang/Object;
      //   434: checkcast android/view/KeyEvent
      //   437: astore_1
      //   438: new android/content/Intent
      //   441: dup
      //   442: ldc_w '508'
      //   445: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   448: invokespecial <init> : (Ljava/lang/String;)V
      //   451: astore_3
      //   452: aload_3
      //   453: ldc_w '509'
      //   456: invokestatic xbd520268 : (Ljava/lang/String;)Ljava/lang/String;
      //   459: aload_1
      //   460: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
      //   463: pop
      //   464: aload_2
      //   465: aload_3
      //   466: invokevirtual onMediaButtonEvent : (Landroid/content/Intent;)Z
      //   469: ifne -> 729
      //   472: aload_0
      //   473: aload_1
      //   474: aload_2
      //   475: invokespecial onMediaButtonEvent : (Landroid/view/KeyEvent;Landroid/support/v4/media/session/MediaSessionCompat$Callback;)V
      //   478: goto -> 729
      //   481: aload_2
      //   482: aload_1
      //   483: getfield obj : Ljava/lang/Object;
      //   486: checkcast java/lang/String
      //   489: aload_3
      //   490: invokevirtual onCustomAction : (Ljava/lang/String;Landroid/os/Bundle;)V
      //   493: goto -> 729
      //   496: aload_2
      //   497: aload_1
      //   498: getfield obj : Ljava/lang/Object;
      //   501: checkcast android/support/v4/media/RatingCompat
      //   504: invokevirtual onSetRating : (Landroid/support/v4/media/RatingCompat;)V
      //   507: goto -> 729
      //   510: aload_2
      //   511: aload_1
      //   512: getfield obj : Ljava/lang/Object;
      //   515: checkcast java/lang/Long
      //   518: invokevirtual longValue : ()J
      //   521: invokevirtual onSeekTo : (J)V
      //   524: goto -> 729
      //   527: aload_2
      //   528: invokevirtual onRewind : ()V
      //   531: goto -> 729
      //   534: aload_2
      //   535: invokevirtual onFastForward : ()V
      //   538: goto -> 729
      //   541: aload_2
      //   542: invokevirtual onSkipToPrevious : ()V
      //   545: goto -> 729
      //   548: aload_2
      //   549: invokevirtual onSkipToNext : ()V
      //   552: goto -> 729
      //   555: aload_2
      //   556: invokevirtual onStop : ()V
      //   559: goto -> 729
      //   562: aload_2
      //   563: invokevirtual onPause : ()V
      //   566: goto -> 729
      //   569: aload_2
      //   570: aload_1
      //   571: getfield obj : Ljava/lang/Object;
      //   574: checkcast java/lang/Long
      //   577: invokevirtual longValue : ()J
      //   580: invokevirtual onSkipToQueueItem : (J)V
      //   583: goto -> 729
      //   586: aload_2
      //   587: aload_1
      //   588: getfield obj : Ljava/lang/Object;
      //   591: checkcast android/net/Uri
      //   594: aload_3
      //   595: invokevirtual onPlayFromUri : (Landroid/net/Uri;Landroid/os/Bundle;)V
      //   598: goto -> 729
      //   601: aload_2
      //   602: aload_1
      //   603: getfield obj : Ljava/lang/Object;
      //   606: checkcast java/lang/String
      //   609: aload_3
      //   610: invokevirtual onPlayFromSearch : (Ljava/lang/String;Landroid/os/Bundle;)V
      //   613: goto -> 729
      //   616: aload_2
      //   617: aload_1
      //   618: getfield obj : Ljava/lang/Object;
      //   621: checkcast java/lang/String
      //   624: aload_3
      //   625: invokevirtual onPlayFromMediaId : (Ljava/lang/String;Landroid/os/Bundle;)V
      //   628: goto -> 729
      //   631: aload_2
      //   632: invokevirtual onPlay : ()V
      //   635: goto -> 729
      //   638: aload_2
      //   639: aload_1
      //   640: getfield obj : Ljava/lang/Object;
      //   643: checkcast android/net/Uri
      //   646: aload_3
      //   647: invokevirtual onPrepareFromUri : (Landroid/net/Uri;Landroid/os/Bundle;)V
      //   650: goto -> 729
      //   653: aload_2
      //   654: aload_1
      //   655: getfield obj : Ljava/lang/Object;
      //   658: checkcast java/lang/String
      //   661: aload_3
      //   662: invokevirtual onPrepareFromSearch : (Ljava/lang/String;Landroid/os/Bundle;)V
      //   665: goto -> 729
      //   668: aload_2
      //   669: aload_1
      //   670: getfield obj : Ljava/lang/Object;
      //   673: checkcast java/lang/String
      //   676: aload_3
      //   677: invokevirtual onPrepareFromMediaId : (Ljava/lang/String;Landroid/os/Bundle;)V
      //   680: goto -> 729
      //   683: aload_2
      //   684: invokevirtual onPrepare : ()V
      //   687: goto -> 729
      //   690: aload_0
      //   691: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   694: aload_1
      //   695: getfield arg1 : I
      //   698: iconst_0
      //   699: invokevirtual adjustVolume : (II)V
      //   702: goto -> 729
      //   705: aload_1
      //   706: getfield obj : Ljava/lang/Object;
      //   709: checkcast android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$Command
      //   712: astore_1
      //   713: aload_2
      //   714: aload_1
      //   715: getfield command : Ljava/lang/String;
      //   718: aload_1
      //   719: getfield extras : Landroid/os/Bundle;
      //   722: aload_1
      //   723: getfield stub : Landroid/os/ResultReceiver;
      //   726: invokevirtual onCommand : (Ljava/lang/String;Landroid/os/Bundle;Landroid/os/ResultReceiver;)V
      //   729: aload_0
      //   730: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   733: aconst_null
      //   734: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
      //   737: return
      //   738: astore_1
      //   739: aload_0
      //   740: getfield this$0 : Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
      //   743: aconst_null
      //   744: invokevirtual setCurrentControllerInfo : (Landroidx/media/MediaSessionManager$RemoteUserInfo;)V
      //   747: aload_1
      //   748: athrow
      //   749: goto -> 729
      //   752: aconst_null
      //   753: astore_1
      //   754: goto -> 343
      // Exception table:
      //   from	to	target	type
      //   77	224	738	finally
      //   224	238	738	finally
      //   241	253	738	finally
      //   256	264	738	finally
      //   267	281	738	finally
      //   284	340	738	finally
      //   347	355	738	finally
      //   358	369	738	finally
      //   372	387	738	finally
      //   390	401	738	finally
      //   404	412	738	finally
      //   415	427	738	finally
      //   430	478	738	finally
      //   481	493	738	finally
      //   496	507	738	finally
      //   510	524	738	finally
      //   527	531	738	finally
      //   534	538	738	finally
      //   541	545	738	finally
      //   548	552	738	finally
      //   555	559	738	finally
      //   562	566	738	finally
      //   569	583	738	finally
      //   586	598	738	finally
      //   601	613	738	finally
      //   616	628	738	finally
      //   631	635	738	finally
      //   638	650	738	finally
      //   653	665	738	finally
      //   668	680	738	finally
      //   683	687	738	finally
      //   690	702	738	finally
      //   705	729	738	finally
    }
  }
  
  public static interface OnActiveChangeListener {
    void onActiveChanged();
  }
  
  public static final class QueueItem implements Parcelable {
    public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
        public MediaSessionCompat.QueueItem createFromParcel(Parcel param2Parcel) {
          return new MediaSessionCompat.QueueItem(param2Parcel);
        }
        
        public MediaSessionCompat.QueueItem[] newArray(int param2Int) {
          return new MediaSessionCompat.QueueItem[param2Int];
        }
      };
    
    public static final int UNKNOWN_ID = -1;
    
    private final MediaDescriptionCompat mDescription;
    
    private final long mId;
    
    private MediaSession.QueueItem mItemFwk;
    
    private QueueItem(MediaSession.QueueItem param1QueueItem, MediaDescriptionCompat param1MediaDescriptionCompat, long param1Long) {
      if (param1MediaDescriptionCompat != null) {
        if (param1Long != -1L) {
          this.mDescription = param1MediaDescriptionCompat;
          this.mId = param1Long;
          this.mItemFwk = param1QueueItem;
          return;
        } 
        throw new IllegalArgumentException(v416f9e89.xbd520268("652"));
      } 
      throw new IllegalArgumentException(v416f9e89.xbd520268("653"));
    }
    
    QueueItem(Parcel param1Parcel) {
      this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(param1Parcel);
      this.mId = param1Parcel.readLong();
    }
    
    public QueueItem(MediaDescriptionCompat param1MediaDescriptionCompat, long param1Long) {
      this(null, param1MediaDescriptionCompat, param1Long);
    }
    
    public static QueueItem fromQueueItem(Object param1Object) {
      if (param1Object == null || Build.VERSION.SDK_INT < 21)
        return null; 
      param1Object = param1Object;
      return new QueueItem((MediaSession.QueueItem)param1Object, MediaDescriptionCompat.fromMediaDescription(param1Object.getDescription()), param1Object.getQueueId());
    }
    
    public static List<QueueItem> fromQueueItemList(List<?> param1List) {
      if (param1List == null || Build.VERSION.SDK_INT < 21)
        return null; 
      ArrayList<QueueItem> arrayList = new ArrayList();
      Iterator<?> iterator = param1List.iterator();
      while (iterator.hasNext())
        arrayList.add(fromQueueItem(iterator.next())); 
      return arrayList;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public MediaDescriptionCompat getDescription() {
      return this.mDescription;
    }
    
    public long getQueueId() {
      return this.mId;
    }
    
    public Object getQueueItem() {
      if (this.mItemFwk != null || Build.VERSION.SDK_INT < 21)
        return this.mItemFwk; 
      MediaSession.QueueItem queueItem = new MediaSession.QueueItem((MediaDescription)this.mDescription.getMediaDescription(), this.mId);
      this.mItemFwk = queueItem;
      return queueItem;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(v416f9e89.xbd520268("654"));
      stringBuilder.append(this.mDescription);
      stringBuilder.append(v416f9e89.xbd520268("655"));
      stringBuilder.append(this.mId);
      stringBuilder.append(v416f9e89.xbd520268("656"));
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      this.mDescription.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeLong(this.mId);
    }
  }
  
  class null implements Parcelable.Creator<QueueItem> {
    public MediaSessionCompat.QueueItem createFromParcel(Parcel param1Parcel) {
      return new MediaSessionCompat.QueueItem(param1Parcel);
    }
    
    public MediaSessionCompat.QueueItem[] newArray(int param1Int) {
      return new MediaSessionCompat.QueueItem[param1Int];
    }
  }
  
  static final class ResultReceiverWrapper implements Parcelable {
    public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
        public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel param2Parcel) {
          return new MediaSessionCompat.ResultReceiverWrapper(param2Parcel);
        }
        
        public MediaSessionCompat.ResultReceiverWrapper[] newArray(int param2Int) {
          return new MediaSessionCompat.ResultReceiverWrapper[param2Int];
        }
      };
    
    ResultReceiver mResultReceiver;
    
    ResultReceiverWrapper(Parcel param1Parcel) {
      this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(param1Parcel);
    }
    
    public ResultReceiverWrapper(ResultReceiver param1ResultReceiver) {
      this.mResultReceiver = param1ResultReceiver;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      this.mResultReceiver.writeToParcel(param1Parcel, param1Int);
    }
  }
  
  class null implements Parcelable.Creator<ResultReceiverWrapper> {
    public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel param1Parcel) {
      return new MediaSessionCompat.ResultReceiverWrapper(param1Parcel);
    }
    
    public MediaSessionCompat.ResultReceiverWrapper[] newArray(int param1Int) {
      return new MediaSessionCompat.ResultReceiverWrapper[param1Int];
    }
  }
  
  public static final class Token implements Parcelable {
    public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
        public MediaSessionCompat.Token createFromParcel(Parcel param2Parcel) {
          Parcelable parcelable;
          IBinder iBinder;
          if (Build.VERSION.SDK_INT >= 21) {
            parcelable = param2Parcel.readParcelable(null);
          } else {
            iBinder = parcelable.readStrongBinder();
          } 
          return new MediaSessionCompat.Token(iBinder);
        }
        
        public MediaSessionCompat.Token[] newArray(int param2Int) {
          return new MediaSessionCompat.Token[param2Int];
        }
      };
    
    private IMediaSession mExtraBinder;
    
    private final Object mInner;
    
    private final Object mLock = new Object();
    
    private VersionedParcelable mSession2Token;
    
    Token(Object param1Object) {
      this(param1Object, null, null);
    }
    
    Token(Object param1Object, IMediaSession param1IMediaSession) {
      this(param1Object, param1IMediaSession, null);
    }
    
    Token(Object param1Object, IMediaSession param1IMediaSession, VersionedParcelable param1VersionedParcelable) {
      this.mInner = param1Object;
      this.mExtraBinder = param1IMediaSession;
      this.mSession2Token = param1VersionedParcelable;
    }
    
    public static Token fromBundle(Bundle param1Bundle) {
      if (param1Bundle == null)
        return null; 
      IMediaSession iMediaSession = IMediaSession.Stub.asInterface(BundleCompat.getBinder(param1Bundle, v416f9e89.xbd520268("667")));
      VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(param1Bundle, v416f9e89.xbd520268("668"));
      Token token = (Token)param1Bundle.getParcelable(v416f9e89.xbd520268("669"));
      return (token == null) ? null : new Token(token.mInner, iMediaSession, versionedParcelable);
    }
    
    public static Token fromToken(Object param1Object) {
      return fromToken(param1Object, null);
    }
    
    public static Token fromToken(Object param1Object, IMediaSession param1IMediaSession) {
      if (param1Object != null && Build.VERSION.SDK_INT >= 21) {
        if (param1Object instanceof MediaSession.Token)
          return new Token(param1Object, param1IMediaSession); 
        throw new IllegalArgumentException(v416f9e89.xbd520268("670"));
      } 
      return null;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof Token))
        return false; 
      Token token = (Token)param1Object;
      param1Object = this.mInner;
      if (param1Object == null)
        return (token.mInner == null); 
      Object object = token.mInner;
      return (object == null) ? false : param1Object.equals(object);
    }
    
    public IMediaSession getExtraBinder() {
      synchronized (this.mLock) {
        return this.mExtraBinder;
      } 
    }
    
    public VersionedParcelable getSession2Token() {
      synchronized (this.mLock) {
        return this.mSession2Token;
      } 
    }
    
    public Object getToken() {
      return this.mInner;
    }
    
    public int hashCode() {
      Object object = this.mInner;
      return (object == null) ? 0 : object.hashCode();
    }
    
    public void setExtraBinder(IMediaSession param1IMediaSession) {
      synchronized (this.mLock) {
        this.mExtraBinder = param1IMediaSession;
        return;
      } 
    }
    
    public void setSession2Token(VersionedParcelable param1VersionedParcelable) {
      synchronized (this.mLock) {
        this.mSession2Token = param1VersionedParcelable;
        return;
      } 
    }
    
    public Bundle toBundle() {
      null = new Bundle();
      null.putParcelable(v416f9e89.xbd520268("671"), this);
      synchronized (this.mLock) {
        IMediaSession iMediaSession = this.mExtraBinder;
        if (iMediaSession != null)
          BundleCompat.putBinder(null, v416f9e89.xbd520268("672"), iMediaSession.asBinder()); 
        VersionedParcelable versionedParcelable = this.mSession2Token;
        if (versionedParcelable != null)
          ParcelUtils.putVersionedParcelable(null, v416f9e89.xbd520268("673"), versionedParcelable); 
        return null;
      } 
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      if (Build.VERSION.SDK_INT >= 21) {
        param1Parcel.writeParcelable((Parcelable)this.mInner, param1Int);
        return;
      } 
      param1Parcel.writeStrongBinder((IBinder)this.mInner);
    }
  }
  
  class null implements Parcelable.Creator<Token> {
    public MediaSessionCompat.Token createFromParcel(Parcel param1Parcel) {
      Parcelable parcelable;
      IBinder iBinder;
      if (Build.VERSION.SDK_INT >= 21) {
        parcelable = param1Parcel.readParcelable(null);
      } else {
        iBinder = parcelable.readStrongBinder();
      } 
      return new MediaSessionCompat.Token(iBinder);
    }
    
    public MediaSessionCompat.Token[] newArray(int param1Int) {
      return new MediaSessionCompat.Token[param1Int];
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */