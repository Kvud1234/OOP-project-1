import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener {
    private JLabel title, name, number, gender, dob, res;
    private JTextField tname, tnumber;
    private JRadioButton male, female;
    private JComboBox<String> date, month, year;
    private JTextArea tadd, tout, resadd;
    private JCheckBox term;
    private JButton sub, reset;

    private Container c;
    private String[] dates={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    private String[] months={"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
    private String[] years={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};

    public RegistrationForm(){
        setTitle("Registration Form");
        setBounds(300,90,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title= new JLabel("Registration Form");
        title.setFont(new Font("",Font.PLAIN,15));
        title.setSize(300,30);
        title.setLocation(300,30);
        c.add(title);

        name=new JLabel("Name");
        name.setFont(new Font("", Font.PLAIN, 15));
        name.setSize(100,20);
        name.setLocation(100,100);
        c.add(name);

        tname=new JTextField();
        tname.setFont(new Font("", Font.PLAIN, 15));
        tname.setSize(190,20);
        tname.setLocation(200,100);
        c.add(tname);

        number=new JLabel("Mobile");
        number.setFont(new Font("", Font.PLAIN, 15));
        number.setSize(100,20);
        number.setLocation(100,150);
        c.add(number);

        tnumber=new JTextField();
        tnumber.setFont(new Font("", Font.PLAIN, 15));
        tnumber.setSize(150,20);
        tnumber.setLocation(200,150);
        c.add(tnumber);

        gender = new JLabel("Gender");
        gender.setFont(new Font("", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);


        male = new JRadioButton("Male");
        male.setFont(new Font("", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("", Font.PLAIN, 15));
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Date Of Birth");
        dob.setFont(new Font("", Font.PLAIN, 15));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox<>(dates);
        date.setFont(new Font("", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox<>(months);
        month.setFont(new Font("", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);

        JLabel add = new JLabel("Address");
        add.setFont(new Font("", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms and Conditions.");
        term.setFont(new Font("", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("", Font.PLAIN, 15));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data = "Name: " + tname.getText() + "\nMobile: " + tnumber.getText() + "\n";
                String data1 = (male.isSelected() ? "Gender: Male" : "Gender: Female") + "\n";
                String data2 = "DOB: " + date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem() + "\n";
                String data3 = "Address: " + tadd.getText();
                tout.setText(data + data1 + data2 + data3);
                res.setText("Registration Successful!");
            } else {
                res.setText("Please accept the Terms & Conditions.");
            }
        } else if (e.getSource() == reset) {
            tname.setText("");
            tnumber.setText("");
            tadd.setText("");
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            res.setText("");
            tout.setText("");
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
