package for_pile_class_lab;
//omoremi adeleke
// 1 December 2018
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Tableau {
	// a standard deck of cards
	private Deck myDeck;
	// refers to an array of card buttons
	// to remove cards from pile
	private SolitairePile mySolPiles[];// solitairePile

	public Tableau(JLayeredPane[] theLPs, JButton[][] theButtons) {
		myDeck = new Deck();
		myDeck.shuffle();
		mySolPiles = new SolitairePile[4];

		for(int i = 0; i<4; i++) {
			mySolPiles[i]= new SolitairePile(theLPs[i], theButtons[i]);	//constructs new pile
		}//for
	}//Tableau constructor
 
	public boolean enoughCardsToDeal() {
		return myDeck.cardsLeft()>=4;
	}//enoughCardsToDeal

	public void dealFourCards() {
		for(int i = 0; i<4; i++) {
			if (myDeck.cardsLeft() > 0 && !mySolPiles[i].isFull()) {	
				CardWithImage d = myDeck.dealOne(true);
				mySolPiles[i].acceptCard(d);
			}//if
		}//for
	}//dealFourCards

	public boolean acesOnlyInPilesDeckEmpty() {
		if (myDeck.cardsLeft()==0){
			if(mySolPiles[0].winningConfig()==true&& mySolPiles[1].winningConfig()==true
					&&mySolPiles[2].winningConfig()==true&&mySolPiles[3].winningConfig()==true&&myDeck.cardsLeft()==0) {
				return true;
			}
		}return false;
	}//acesOnlyInPilesDeckEmpty

	public boolean okayToRemove(int removeFromPile) {
		if(mySolPiles[removeFromPile].numberOfCardsInPile()>0) {
			CardWithImage cardToBeRemoved = mySolPiles[removeFromPile].getTopCard();
			String suitOfCardToBeRemoved = cardToBeRemoved.getSuit();
			int valueOfCardToBeRemoved = cardToBeRemoved.getValue();
			for(int i = 0; i<4; i++) {
				if(i != removeFromPile && !mySolPiles[i].isEmpty()) {
					CardWithImage cardsToCompare= mySolPiles[i].getTopCard();
					if(cardsToCompare.getSuit().equals(suitOfCardToBeRemoved)) {
						if(cardsToCompare.getValue()>valueOfCardToBeRemoved) {
							return true;
						}//getValue
					}//getSuit
				}//if !samePile
			}//for
		}return false;
	}//okayToRemove

	public void removeTopCardofPile(int removeFromPile) {
		mySolPiles[removeFromPile].removeCard();

	}//removes TopCardOfPile

	public boolean okayMoveFromTo(int source, int destination) {
		return !mySolPiles[source].isEmpty() && mySolPiles[destination].isEmpty();
	}//okay moveFromTo

	public void moveFromTo(int source, int destination) {
		CardWithImage cardToNewPile = mySolPiles[source].getTopCard();//cardToNewPile is the card fisrt clicked 
		mySolPiles[destination].acceptCard(cardToNewPile);
		mySolPiles[source].removeCard();
	}//moves fromTo
}


//deal b and card b ask tableau

//doneBHandler
//disable all buttons
//ask tableau obj
//wherether user has wone
//
//if (myTableau.allPileWinConfigAndDeckEmpty) {
//	//winn messga;
//else {
//	false mess;
//}
//}