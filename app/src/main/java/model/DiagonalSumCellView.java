package model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

import com.example.kakuro_game_android.R;

public class DiagonalSumCellView extends View {
    private Paint linePaint;
    private Paint textPaint;
    private String verticalSum;
    private String horizontalSum;
    private int textSize;

    public DiagonalSumCellView(Context context, String verticalSum, String horizontalSum) {
        super(context);
        this.verticalSum = verticalSum;
        this.horizontalSum = horizontalSum;
        init();
    }

    private void init() {
        // Initialize line paint for the diagonal line
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.parseColor("#475A7D"));
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);

        // Initialize text paint for the sums
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textSize = getResources().getDimensionPixelSize(R.dimen.text_size);
        textPaint.setTextSize(textSize);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the diagonal line
        canvas.drawLine(0, 0, getWidth(), getHeight(), linePaint);

        // Draw the vertical sum using textPaint
        float verticalTextWidth = textPaint.measureText(verticalSum);
        canvas.drawText(verticalSum, (getWidth() - verticalTextWidth) / 2, textSize, textPaint);

        // Draw the horizontal sum using textPaint
        float horizontalTextHeight = textSize + (getHeight() - textSize) / 2;
        canvas.drawText(horizontalSum, textSize / 2, horizontalTextHeight, textPaint);
    }
}
