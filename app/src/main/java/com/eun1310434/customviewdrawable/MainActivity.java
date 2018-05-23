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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 직접 만든 뷰를 화면에 설정
        CustomViewDrawables myView = new CustomViewDrawables(this);
        setContentView(myView);
    }

}
