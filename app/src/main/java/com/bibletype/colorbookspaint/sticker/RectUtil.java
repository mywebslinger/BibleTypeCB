package com.bibletype.colorbookspaint.sticker;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by panyi on 2016/6/16.
 */
class RectUtil {
    static void scaleRect(RectF rect, float scale) {
        float w = rect.width();
        float h = rect.height();

        float newW = scale * w;
        float newH = scale * h;

        float dx = (newW - w) / 2;
        float dy = (newH - h) / 2;

        rect.left -= dx;
        rect.top -= dy;
        rect.right += dx;
        rect.bottom += dy;
    }


    static void rotateRect(RectF rect, float center_x, float center_y,
                           float roatetAngle) {
        float x = rect.centerX();
        float y = rect.centerY();
        float sinA = (float) Math.sin(Math.toRadians(roatetAngle));
        float cosA = (float) Math.cos(Math.toRadians(roatetAngle));
        float newX = center_x + (x - center_x) * cosA - (y - center_y) * sinA;
        float newY = center_y + (y - center_y) * cosA + (x - center_x) * sinA;

        float dx = newX - x;
        float dy = newY - y;

        rect.offset(dx, dy);
    }


    static void rotatePoint(Point p, float center_x, float center_y,
                            float roatetAngle) {
        float sinA = (float) Math.sin(Math.toRadians(roatetAngle));
        float cosA = (float) Math.cos(Math.toRadians(roatetAngle));
        // calc new point
        float newX = center_x + (p.x - center_x) * cosA - (p.y - center_y) * sinA;
        float newY = center_y + (p.y - center_y) * cosA + (p.x - center_x) * sinA;
        p.set((int)newX , (int)newY);
    }


    static void rectAddV(final Rect srcRect, final Rect addRect, int padding, int charMinHeight) {
        if (srcRect == null || addRect == null)
            return;

        int left = srcRect.left;
        int top = srcRect.top;
        int right = srcRect.right;
        int bottom = srcRect.bottom;

        if (srcRect.width() <= addRect.width()) {
            right = left + addRect.width();
        }

        bottom += padding + Math.max(addRect.height(), charMinHeight);

        srcRect.set(left, top, right, bottom);
    }
}//end class
