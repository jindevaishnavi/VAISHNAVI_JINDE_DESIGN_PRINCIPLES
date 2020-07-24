import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Graphics;
@SuppressWarnings("deprecation")
public class Calculator extends Applet implements ActionListener
{
String text="";
	JTextField t1;
	JButton b[]=new JButton[10];
	JButton add,sub,mul,div,clear,mod,equal;
	int p,q,op_result;
	char op;
	
	public void init()
	{
		
		
		t1=new JTextField(10);
		GridLayout gl=new GridLayout(4,5);
		setLayout(gl);
		for(int i=0;i<10;i++)
			b[i]=new JButton(""+i);
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		mod=new JButton("%");
		clear=new JButton("C");
		equal=new JButton("=");
		t1.addActionListener(this);
		add(t1);
		for(int i=0;i<10;i++)
			add(b[i]);
		add(add);
		add(sub);
		add(mul);
		add(div);
		add(mod);
		add(clear);
		add(equal);
		for(int i=0;i<10;i++)
		b[i].addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
		clear.addActionListener(this);
		equal.addActionListener(this);
		//paint();
		JPanel p = new JPanel(); 
		p.setBackground(Color.blue); 
	}
	public void paint(Graphics g){
		 /*
		 * To resize an applet window use,
		 * void resize(int x, int y) method of an applet class.
		 */
		 resize(500,500);
		// g.drawString("", 50, 50);
		 }
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		char ch=str.charAt(0);
		if(Character.isDigit(ch))
			t1.setText(t1.getText()+str);
		else if(str.equals("+"))
		{
			p=Integer.parseInt(t1.getText());
			op='+';
			t1.setText("");
		}
		else if(str.equals("-"))
		{
			p=Integer.parseInt(t1.getText());
			op='-';
			t1.setText("");
		}
		else if(str.equals("*"))
		{
			p=Integer.parseInt(t1.getText());
			op='*';
			t1.setText("");
		}
		else if(str.equals("/"))
		{
			p=Integer.parseInt(t1.getText());
			op='/';
			t1.setText("");
		}
		else if(str.equals("%"))
		{
			p=Integer.parseInt(t1.getText());
			op='%';
			t1.setText("");
		}
		if(str.equals("="))
		{
			q=Integer.parseInt(t1.getText());
			if(op=='+')
				op_result=p+q;
			else if(op=='-')
				op_result=p-q;
			else if(op=='*')
				op_result=p*q;
			else if(op=='/')
				op_result=p/q;
			else if(op=='%')
				op_result=p%q;
			t1.setText(""+op_result);;
		}
		if(str.equals("clear"))
			t1.setText("");
	}
}