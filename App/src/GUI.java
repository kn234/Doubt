import java.awt.* ;
import java.awt.event.* ;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.* ;

public class GUI extends JFrame {
    private JButton result = new JButton("Result");
    private JButton addman = new JButton("Add Friend");
    private JButton viewmap = new JButton("Result");
    private JTextField inputman = new JTextField("", 5);
    private JTextField inputmoney = new JTextField("", 5);
    private JLabel label = new JLabel("Name: ");
    private JLabel label1 = new JLabel("Money: ");
    private JLabel label2 = new JLabel("nothing");
    //private JCheckBox check = new JCheckBox("Check", false);
    Map<String, Integer> db = new HashMap<String, Integer>();
    Map<String, Integer> resdb = new HashMap<String, Integer>();
    public GUI(){
        super("Gayshittt");
        this.setBounds(500,300,500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(label);
        container.add(inputman);
        container.add(label1);
        container.add(inputmoney);
        //container.add(check);
        result.addActionListener(new ButtonEventListener());
        container.add(result);
        addman.addActionListener(new AddFriend());
        container.add(addman);
        container.add(label2);



    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

            resdb.putAll(db);
            Integer sum=0;
            for (Integer i : db.values()){
                sum+=i;
            }
            for(String key : db.keySet()){
                System.out.println(key);
                resdb.put(key, db.get(key)-sum/db.size());
            }
            String message=resdb.toString();
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class AddFriend implements ActionListener {
        public void actionPerformed(ActionEvent e){
            db.put(inputman.getText(), Integer.valueOf(inputmoney.getText()));
            System.out.println(db);

            label2.setText(db.toString());
        }
    }
    /*
    class ViewTable implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String message=map;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }*/

}

