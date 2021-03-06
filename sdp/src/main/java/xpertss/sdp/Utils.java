/**
 * Created By: cfloersch
 * Date: 5/26/13
 * Copyright 2013 XpertSoftware
 */
package xpertss.sdp;

import java.lang.reflect.Array;
import java.util.Date;

import static java.util.concurrent.TimeUnit.SECONDS;
import static xpertss.sdp.SdpConstants.NTP_CONST;

class Utils {

   public static long currentNtpTime()
   {
      return ((System.currentTimeMillis() / 1000) + NTP_CONST);
   }

   public static long toNtpTime(Date d)
   {
      if (d == null) return 0;
      return ((d.getTime() / 1000) + NTP_CONST);
   }

   public static Date toDate(long ntpTime)
   {
      return (ntpTime == 0) ? null : new Date((ntpTime - NTP_CONST) * 1000);
   }

   public static String toCompactTime(long duration)
   {
      if(duration != 0) {
         if(duration % 86400  == 0) {
            return SECONDS.toDays(duration) + "d";
         } else if(duration % 3600 == 0) {
            return SECONDS.toHours(duration) + "h";
         } else if(duration % 60 == 0) {
            return SECONDS.toMinutes(duration) + "m";
         }
      }
      return Long.toString(duration);
   }

   public static int[] emptyIfNull(int[] data)
   {
      return (data == null) ? new int[0] : data;
   }

   public static int[] hasItem(int[] data, String msg)
   {
      if(data == null || data.length < 1)
         throw new IllegalArgumentException(msg);
      return data;
   }


   public static long[] emptyIfNull(long[] data)
   {
      return (data == null) ? new long[0] : data;
   }

   public static long[] hasItem(long[] data, String msg)
   {
      if(data == null || data.length < 1)
         throw new IllegalArgumentException(msg);
      return data;
   }


   public static <T,U> T[] emptyIfNull(T[] data, Class<? extends T[]> type)
   {
      return (data == null) ? (T[]) Array.newInstance(type.getComponentType(), 0) : data;
   }

   public static <T> T[] hasItem(T[] data, String msg)
   {
      if(data == null || data.length < 1 || data[0] == null)
         throw new IllegalArgumentException(msg);
      return data;
   }
}
