package for_pile_class_lab;
//Omoremi Adeleke
//27 November 2018
import javax.swing.*;

public class SolitairePile extends Pile {

	public SolitairePile(JLayeredPane thePane, JButton theButtons[]) {
		super(thePane, theButtons);
	}

	public int numberOfCardsInPile() {
		return myTopCardIndex;
	}

	public CardWithImage getTopCard() {
		if (myTopCardIndex >= 1 && myTopCardIndex <= 13) {
			return myCards[myTopCardIndex];
		}
		return null;
	}

	public boolean winningConfig() {
		return myTopCardIndex == 1 && myCards[myTopCardIndex].getValue() == 14;
		}//winningConfig
	}

