package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		// this will maintain all loans information
		NewsPaper printMedia = new NewsPaper();
        Internet onlineMedia = new Internet();

        Loan personalLoan = new Loan("Personal Loan", 12.5f,
                     "Standard Charterd");
        personalLoan.registerObserver(onlineMedia);
        personalLoan.registerObserver(printMedia);
        personalLoan.setInterest(15);
	}

}

interface Observer{
	public void update(float interest);
}

interface Subject{
	public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}

class Loan implements Subject{
	
	private List<Observer> observers = new ArrayList<Observer>();
    private String type;
    private float interest;
    private String bank;
    
    public Loan(String type, float interest, String bank) {
        this.type = type;
        this.interest = interest;
        this.bank = bank;
 }
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
		notifyObservers();
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println("Notifying the observers.");
		for(Observer o:observers) {
			o.update(this.interest);
		}
	}	
}

class NewsPaper implements Observer{

	@Override
	public void update(float interest) {
		System.out.println("Newspaper: Interest Rate updated, new Rate is: "+ interest);		
	}
}

class Internet implements Observer {
    @Override
    public void update(float interest) {
           System.out.println("Internet: Interest Rate updated, new Rate is: "
                        + interest);
    }
}
