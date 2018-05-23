/*=====================================================================
□ INFORMATION
  ○ Data : 23.05.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ FUNCTION
  ○ 뷰를 상속하여 새로운 뷰를 만들기
     - XML레이아웃으로 만든 것이 아닌 직접 만든 뷰 설정
  ○ 터치 이벤트
     - 터치한 위치에 그림그리기
     - 처음 터치한 좌표, 터치 중인 좌표, 마지막 터치한 좌표를 출력

□ STUDY
  ○ View
     - This class represents the basic building block for user interface components.
       A View occupies a rectangular area on the screen and is responsible for drawing and event handling.
       View is the base class for widgets, which are used to create interactive UI components (buttons, text fields, etc.).
       The ViewGroup subclass is the base class for layouts, which are invisible containers that hold other Views (or other ViewGroups) and define their layout properties.
=====================================================================*/

package com.eun1310434.customviewdrawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CustomViewDrawables extends View {

	private ShapeDrawable upperDrawable;
	private ShapeDrawable lowerDrawable;

	public CustomViewDrawables(Context context) {
		super(context);

		// get display size
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
	    Display display = manager.getDefaultDisplay();
	    Point sizePoint = new Point();
	    display.getSize(sizePoint);
	    int width = sizePoint.x;
	    int height = sizePoint.y;

	    // get colors
		Resources curRes = getResources();
		int colorAccent = curRes.getColor(R.color.colorAccent);
		int colorPrimary = curRes.getColor(R.color.colorPrimary);
		int colorPrimaryDark = curRes.getColor(R.color.colorPrimaryDark);

		// create the upper drawable
		upperDrawable = new ShapeDrawable();

		RectShape rectangle = new RectShape();
		rectangle.resize(width, height*2/3);
		upperDrawable.setShape(rectangle);
		upperDrawable.setBounds(0, 0, width, height*2/3);


		//점차 색상이 변경되는 효과
		LinearGradient gradient = new LinearGradient(0, 0, 0, height*2/3, colorPrimary, colorAccent, TileMode.CLAMP);

		Paint paint = upperDrawable.getPaint();
		paint.setShader(gradient); //점차 색상이 변경되는 효과 적용

		// create the lower drawable
		lowerDrawable = new ShapeDrawable();

		RectShape rectangle2 = new RectShape();
		rectangle2.resize(width, height*1/3);
		lowerDrawable.setShape(rectangle2);
		lowerDrawable.setBounds(0, height*2/3, width, height);

		LinearGradient gradient2 = new LinearGradient(0, 0, 0, height*1/3, colorAccent, colorPrimaryDark, TileMode.CLAMP);

		Paint paint2 = lowerDrawable.getPaint();
		paint2.setShader(gradient2);

	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		upperDrawable.draw(canvas);
		lowerDrawable.draw(canvas);

		// Paint
		Paint pathPaint = new Paint();
		pathPaint.setAntiAlias(true);
		pathPaint.setColor(Color.CYAN);
		pathPaint.setStyle(Style.STROKE);
		pathPaint.setStrokeWidth(16.0F);
		pathPaint.setStrokeCap(Cap.BUTT);
		pathPaint.setStrokeJoin(Join.MITER);

		// Path
		Path path = new Path();
		path.moveTo(20, 20);
		path.lineTo(120, 20);
		path.lineTo(160, 90);
		path.lineTo(180, 500);
		path.lineTo(200, 200);
		path.lineTo(400, 30);
		path.lineTo(500, 20);
		path.lineTo(700, 5);

		canvas.drawPath(path, pathPaint);

		pathPaint.setColor(Color.GREEN);
		pathPaint.setStrokeCap(Cap.ROUND);
		pathPaint.setStrokeJoin(Join.ROUND);

		path.offset(80, 500);
		canvas.drawPath(path, pathPaint);

		pathPaint.setColor(Color.BLUE);
		pathPaint.setStrokeCap(Cap.SQUARE);
		pathPaint.setStrokeJoin(Join.BEVEL);

		path.offset(80, 700);
		canvas.drawPath(path, pathPaint);

	}

}
