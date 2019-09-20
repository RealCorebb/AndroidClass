package com.example.mystar;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends Activity {
 EditText edittext_name; //����������EditText�ؼ�
 DatePicker datepicker_bir; //ѡ�����ڵĿؼ� 
 Button btn_search; //��ѯ��ť�ؼ� 
 ImageView imageview_star; //����ͼƬ�ؼ� 
 TextView textview_info; //������Ϣ�ؼ�
@Override
protected void onCreate(Bundle savedInstanceState) { 
	super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
	edittext_name = (EditText)this.findViewById(R.id.editTextName);
	datepicker_bir = (DatePicker)this.findViewById(R.id.datePickerBir); 
	btn_search = (Button)this.findViewById(R.id.buttonSearch); 
	imageview_star = (ImageView)this.findViewById(R.id.imageViewStar); 
	textview_info = (TextView)this.findViewById(R.id.textViewInfo);
 btn_search.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) { // TODO Auto-generated method stub 
	int month = datepicker_bir.getMonth();
//��ȡ��ǰѡ����·�
	int day = datepicker_bir.getDayOfMonth();
//��ȡ��ǰѡ�����
	int index = searchStar(month, day); //����searchStar�������ջ�ȡ��Ӧ������������0��11��ˮƿ����Ħ������
	int[] infoarray = {R.string.aquarius, R.string.pisces,R.string.aries, R.string.taurus,R.string.gemini,R.string.cancer, R.string.leo, R.string.virgo,
 R.string.libra,R.string.scorpio, R.string.sagittarius, R.string.capricornus};
	int[] imgarray = {R.drawable.aquarius, R.drawable.pisces,R.drawable.aries, R.drawable.taurus,R.drawable.gemini,
		 R.drawable.cancer, R.drawable.leo, R.drawable.virgo,R.drawable.libra,R.drawable.scorpio, R.drawable.sagittarius, R.drawable.capricornus};
String star = MainActivity.this.getString(infoarray[index]); //����������ȡ������Ϣ�ַ���
 textview_info.setText(edittext_name.getText().toString()+"�����������Ϣ���£�\r\n"+star); //�趨������Ϣ�ؼ�
 imageview_star.setImageResource(imgarray[index]);
//���������趨����ͼƬ
 }});
}
@Override
public boolean onCreateOptionsMenu(Menu menu) { // Inflate the menu; this adds items to the action bar if it is present. 
	getMenuInflater().inflate(R.menu.main, menu); return true;
}
//�������ջ�ȡ����������������0-11�ֲ�����ʮ����������-1��������쳣
public int searchStar(int month, int day)
{ 
	int[] DayArr = {20, 19, 21, 20, 21, 22, 23, 23, 24, 23, 22}; // ���������ָ���
	int index = month;
 // ����ѯ�����ڷָ���֮ǰ��������һ�����򲻱� 
	if (day < DayArr[month]) { 
	index = index - 1;
	if( index < 0 )
	{ 
	index = 11; 
	} 
	}
 return index;
}
}