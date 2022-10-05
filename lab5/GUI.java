package lab5;
import java.util.ArrayList;
import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class GUI extends JFrame implements ActionListener {

	private JButton load, save, search, next, add, delete;
	private JTextField searchField, nameField, numberField;
	private JPanel panelText, panelButton;
	private boolean enabled = true;
	private PhoneBook pb = new PhoneBook();
	
	private ArrayList<Person> psr;
	private int counter;
	
	public GUI() {
		
		Font myFont = new Font("SanSerif", Font.PLAIN, 20);
		
		load = new JButton("Load PhoneBook"); load.setFont(myFont); load.addActionListener(this);
		save = new JButton("Save PhoneBook"); save.setFont(myFont); save.addActionListener(this);
		search = new JButton("Search"); search.setFont(myFont); search.addActionListener(this);
		next = new JButton("Next name"); next.setFont(myFont); next.addActionListener(this);
		add = new JButton("Add person"); add.setFont(myFont); add.addActionListener(this);
		delete = new JButton("Deleted person"); delete.setFont(myFont); delete.addActionListener(this);
		
		toggle();
		
		panelButton = new JPanel(new GridLayout(3,2));
		panelButton.add(load); panelButton.add(save);
		panelButton.add(search); panelButton.add(next);
		panelButton.add(add); panelButton.add(delete);
		
		searchField = new JTextField(); searchField.setFont(myFont);
		nameField = new JTextField(); nameField.setFont(myFont); nameField.setEditable(false);
		numberField = new JTextField(); numberField.setFont(myFont); numberField.setEditable(false);
		  
		
		panelText = new JPanel(new GridLayout(3,1));
		panelText.add(searchField); panelText.add(nameField); panelText.add(numberField);
		
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,2));
		c.add(panelButton); c.add(panelText);
		c.setBackground(Color.WHITE);
		setVisible(true); pack();
		setTitle("Interactive phone book"); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == load) {
			String load = pb.load(searchField.getText());
			searchField.setText("");
			nameField.setText(load);
			if(load.length() == 17) {
				toggle();
				next.setEnabled(false);
			}
		}
		
		if(e.getSource() == save) {
			String save = pb.save(searchField.getText());
			searchField.setText("");
			nameField.setText(save);
		}
		
		if(e.getSource() == search) {
			String outS = "";
			String outI = "";
			
			psr = pb.search(searchField.getText());
			if(psr.size() > 0) {
				outS = psr.get(0).getFullName();
				outI = psr.get(0).getPhoneNumber()+"";
				if(psr.size() > 1) {
					counter = 0;
					next.setEnabled(true);
				}
			}  
			else {
				outS = "Provide a name";
			}
			
			nameField.setText(outS);
			numberField.setText(outI);
		}
		
		if(e.getSource() == next) {
			counter++;
			nameField.setText(psr.get(counter).getFullName());
			numberField.setText(psr.get(counter).getPhoneNumber()+"");
			if(counter >= psr.size()-1) {
				counter = 0;
				next.setEnabled(false);
			}
		}
		
		if(e.getSource() == delete) {
			try {
				String name = nameField.getText();
				int num = Integer.parseInt(numberField.getText());
				searchField.setText(pb.deletePerson(name, num));
			} catch(NumberFormatException err){
				searchField.setText("Invalid number");
			}
		}
		
		if(e.getSource() == add) {
			if(nameField.isEditable()) {
				try {
					if(pb.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()))) {
						searchField.setText("Person added");
						nameField.setEditable(false);
						numberField.setEditable(false);
						nameField.setText("");
						numberField.setText("");
					} else {
						searchField.setText("Try Again");
					}
				} catch(NumberFormatException err) {}
			} else {
				searchField.setText("Type in name and phone number");
				nameField.setEditable(true);
				numberField.setEditable(true);
			}
		}
		
	}
	
	public void toggle() {
		if(enabled) {
			load.setEnabled(true); save.setEnabled(false); search.setEnabled(false); next.setEnabled(false); add.setEnabled(false);
			delete.setEnabled(false); enabled = false;
		} else {
			load.setEnabled(true); save.setEnabled(true); search.setEnabled(true); next.setEnabled(true); add.setEnabled(true);
			delete.setEnabled(true); enabled = true;
		}
			
	}
	
	public static void main(String[] args) {
		new GUI();
	}

}