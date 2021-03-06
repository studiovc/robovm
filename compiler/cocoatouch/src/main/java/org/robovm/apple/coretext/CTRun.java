/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.coretext;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.annotation.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.coremedia.*;
import org.robovm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreText")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CTRun/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<?> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(cls, handle, flags);
            if (o == null) {
                return null;
            }
            return o.toList(CTRun.class);
        }
        @MarshalsPointer
        public static long toNative(List<? extends CFType> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray o = null;
            if (l instanceof CFArray) {
                o = (CFArray) l;
            } else {
                o = CFArray.create((List<? extends CFType>) l);
            }
            return CFType.Marshaler.toNative(o, flags);
        }
    }
    
    /*<ptr>*/public static class CTRunPtr extends Ptr<CTRun, CTRunPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CTRun.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CTRun() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @WeaklyLinked
    public NSAttributedStringAttributes getAttributes() {
        NSDictionary dict = getAttributesDictionary();
        if (dict == null) return null;
        return new NSAttributedStringAttributes(dict);
    }
    @WeaklyLinked
    public CMTextMarkupAttributes getTextMarkupAttributes() {
        NSDictionary dict = getAttributesDictionary();
        if (dict == null) return null;
        return new CMTextMarkupAttributes(getAttributesDictionary().as(CFDictionary.class));
    }
    public CTAttributedStringAttributes getCoreTextAttributes() {
        NSDictionary dict = getAttributesDictionary();
        if (dict == null) return null;
        return new CTAttributedStringAttributes(getAttributesDictionary().as(CFDictionary.class));
    }
    
    /**
     * @since Available in iOS 3.2 and later.
     */
    public short[] getGlyphs(@ByVal CFRange range) {
        ShortPtr ptr = new ShortPtr();
        getGlyphs(range, ptr);
        return ptr.toShortArray((int) getGlyphCount());
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public CGPoint[] getPositions(@ByVal CFRange range) {
        CGPoint p = Struct.allocate(CGPoint.class, (int)range.getLength());
        getPositions(range, p);
        return p.toArray((int) getGlyphCount());
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public CGSize[] getAdvances(@ByVal CFRange range) {
        CGSize s = Struct.allocate(CGSize.class, (int)range.getLength());
        getAdvances(range, s);
        return s.toArray((int) getGlyphCount());
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public long[] getStringIndices(@ByVal CFRange range) {
        LongPtr ptr = new LongPtr();
        getStringIndices(range, ptr);
        return ptr.toLongArray((int) getGlyphCount());
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getWidth(@ByVal CFRange range) {
        return getTypographicBounds(range, null, null, null);
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getAscent(@ByVal CFRange range) {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getTypographicBounds(range, ptr, null, null);
        return ptr.get();
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getDescent(@ByVal CFRange range) {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getTypographicBounds(range, null, ptr, null);
        return ptr.get();
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getLeading(@ByVal CFRange range) {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getTypographicBounds(range, null, null, ptr);
        return ptr.get();
    }    
    /*<methods>*/
    @Bridge(symbol="CTRunGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="CTRunGetGlyphCount", optional=true)
    public native @MachineSizedSInt long getGlyphCount();
    @Bridge(symbol="CTRunGetAttributes", optional=true)
    public native NSDictionary getAttributesDictionary();
    @Bridge(symbol="CTRunGetStatus", optional=true)
    public native CTRunStatus getStatus();
    @Bridge(symbol="CTRunGetGlyphs", optional=true)
    protected native void getGlyphs(@ByVal CFRange range, ShortPtr buffer);
    @Bridge(symbol="CTRunGetPositions", optional=true)
    protected native void getPositions(@ByVal CFRange range, CGPoint buffer);
    @Bridge(symbol="CTRunGetAdvances", optional=true)
    protected native void getAdvances(@ByVal CFRange range, CGSize buffer);
    @Bridge(symbol="CTRunGetStringIndices", optional=true)
    protected native void getStringIndices(@ByVal CFRange range, LongPtr buffer);
    @Bridge(symbol="CTRunGetStringRange", optional=true)
    public native @ByVal CFRange getStringRange();
    @Bridge(symbol="CTRunGetTypographicBounds", optional=true)
    protected native double getTypographicBounds(@ByVal CFRange range, MachineSizedFloatPtr ascent, MachineSizedFloatPtr descent, MachineSizedFloatPtr leading);
    @Bridge(symbol="CTRunGetImageBounds", optional=true)
    public native @ByVal CGRect getImageBounds(CGContext context, @ByVal CFRange range);
    @Bridge(symbol="CTRunGetTextMatrix", optional=true)
    public native @ByVal CGAffineTransform getTextMatrix();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Bridge(symbol="CTRunGetBaseAdvancesAndOrigins", optional=true)
    public native void getBaseAdvancesAndOrigins(@ByVal CFRange range, CGSize advancesBuffer, CGPoint originsBuffer);
    @Bridge(symbol="CTRunDraw", optional=true)
    public native void draw(CGContext context, @ByVal CFRange range);
    /*</methods>*/
}
