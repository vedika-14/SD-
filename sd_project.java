import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
class sd_project extends Canvas
{  
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        //String s = "HASHING SIMULATION";
        g.drawString("Hello",100,80);
    }

    public static void main(String args[])  
    {  
        sd_project h=new sd_project();
        JFrame f= new JFrame("Hashing");  
        f.add(h);
        JTextField t1,t2;  
        JLabel li,lm,lh;
        JButton b1,b2;
        JRadioButton r1,r2,r3;
        int y;

        //button
        r1=new JRadioButton("Linear");
        r1.setBounds(50,100,70,30); 
        r2=new JRadioButton("Quadratic");
        r2.setBounds(130,100,100,30);
        r3=new JRadioButton("Double");
        r3.setBounds(240,100,80,30);

        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);bg.add(r2);bg.add(r3);
         
        //label for input 
        li = new JLabel("Input");
        li.setBounds(50,160,50,30);    

        //inputfield
        t1=new JTextField("");  
        t1.setBounds(110,160,50,30);  

        //button for inputs
        b1=new JButton("Input");
        b1.setBounds(170,160,100,30);


        //Reset
        b2=new JButton("Reset");  
        b2.setBounds(170,200,100,30); 


        //hash table
        lh = new JLabel("HASH TABLE");
        lh.setBounds(50,260,200,30); 

        JTextField jTextFieldArray[] = new JTextField[10];
        JLabel label_array[] = new JLabel[10];
        String textFieldStrings[] = new String[10];
        y=300;
        String str;
        for(int i = 0 ; i < 10; i++)
        {
            str = Integer.toString(i);
            jTextFieldArray[i] = new JTextField("-1");
            jTextFieldArray[i].setBounds(110,y,50,30);

            label_array[i] = new JLabel(str);
            label_array[i].setBounds(50,y,50,30);

            y = y + 40;
            f.add(jTextFieldArray[i]);
            f.add(label_array[i]);
        }

        b2.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e)
        {         
            t1.setText("");
            for(int j=0;j<10;j++)
                jTextFieldArray[j].setText("-1");
        }}); 


        //action

        b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e)
        {  
            //Linear Hashing
            if(r1.isSelected())
            {
                
                String s1=t1.getText();  
                //String s2=tf2.getText();  
                int key=Integer.parseInt(s1);  
                int index;  
                String result;
                int i;

                if(e.getSource()==b1)
                { 

                    index = key % 10; 

                    if(Integer.parseInt(jTextFieldArray[index].getText()) == -1)
                         jTextFieldArray[index].setText(Integer.toString(key));
                    else
                    {
                        for( i=1;i<10;i++)
                        {
                            index = (key + i) % 10;
                            if(Integer.parseInt(jTextFieldArray[index].getText()) == -1)
                            {
                                jTextFieldArray[index].setText(Integer.toString(key));
                                break;
                            }
                        }
                   }
                }
            }



            if(r2.isSelected())
            {


                String s1=t1.getText();  
                //String s2=tf2.getText();  
                int key=Integer.parseInt(s1);  
                int index;  
                String result;
                int i;

                if(e.getSource()==b1)
                { 
                    index = key % 10; 

                    if(Integer.parseInt(jTextFieldArray[index].getText()) == -1)
                         jTextFieldArray[index].setText(Integer.toString(key));
                    else
                    {
                        for( i=1;i<10;i++)
                        {
                            index = (key + i*i) % 10;
                            if(Integer.parseInt(jTextFieldArray[index].getText()) == -1)
                            {
                                jTextFieldArray[index].setText(Integer.toString(key));
                                break;
                            }
                        }
                   }
                }
            }


            if(r3.isSelected())
            {
                String s1=t1.getText();  
                //String s2=tf2.getText();  
                int key=Integer.parseInt(s1);  
                int index1,index2;  
                String result;
                int i;

                if(e.getSource()==b1)
                { 
                    index1 = key % 10; 
                    index2 = 7 - (key % 7); 

                    if(Integer.parseInt(jTextFieldArray[index1].getText()) == -1)
                        jTextFieldArray[index1].setText(Integer.toString(key));
                    else
                    {
                        for( i=1;i<10;i++)
                        {
                            index1 = (index1 + index2);

                            if(Integer.parseInt(jTextFieldArray[index1%10].getText()) == -1)
                            {
                                jTextFieldArray[index1%10].setText(Integer.toString(key));
                                break;
                            }
                        }
                   }
                }
            }
              
        }}); 

        JPanel p = new JPanel();

        JScrollPane sp = new JScrollPane(p);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.getContentPane().add(sp);


        f.add(r1); f.add(r2); f.add(r3); 
        f.add(li); f.add(lh); 
        f.add(t1);
        f.add(b1); f.add(b2);  
        f.setSize(400,1000);  
        f.setLayout(null);  
        f.setVisible(true);  
    }  
}  