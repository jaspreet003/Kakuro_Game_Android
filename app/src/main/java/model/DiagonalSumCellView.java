package model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.kakuro_game_android.R;

public class DiagonalSumCellView extends View {
    private Paint paint;
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
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textSize = getResources().getDimensionPixelSize(R.dimen.text_size); // Define this in your dimens.xml
        paint.setTextSize(textSize);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the diagonal line
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);

        // Draw the vertical sum
        paint.setStyle(Paint.Style.FILL);
        float verticalTextWidth = paint.measureText(verticalSum);
        canvas.drawText(verticalSum, (getWidth() - verticalTextWidth) / 2, textSize, paint);

        // Draw the horizontal sum
        float horizontalTextHeight = textSize + (getHeight() - textSize) / 2;
        canvas.drawText(horizontalSum, textSize / 2, horizontalTextHeight, paint);
    }
}
