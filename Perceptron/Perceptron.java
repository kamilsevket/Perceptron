package perceptron;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Converted to Java from http://natureofcode.com/book/chapter-10-neural-networks/
// And add AND, OR, NAND Functions

/**
 * 
 * @author Kamil Demirtaş
 */
public class Perceptron {

    public final double[] weights;
    public final double LEARNING_RATE = 0.01;
    public final int EPOCHS = 10000;
    double correct = 0.0, wrong = 0.0;

    public Perceptron( int n ) {
        weights = new double[n];
        //assign initial random weights
        for ( int i = 0; i < weights.length; i++ ) {
            weights[ i ] = ThreadLocalRandom.current().nextDouble( -1, 1 );
            
        }
    }

    public int feedforward( double[] inputs ) {
        double sum = 0;
        for ( int i = 0; i < weights.length; i++ ) {
            sum += inputs[ i ] * weights[ i ];
        }
        return activate( sum );
    }

    private int activate( double sum ) {
        if ( sum > 0 ) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private void train( double[] inputs, int desired ) {
    	
        int guess = feedforward( inputs );
        
        if (guess == desired) {
			correct++;
		} else {
			wrong++;
		}
        
        float error = desired - guess;
        for ( int i = 0; i < weights.length; i++ ) {
            weights[ i ] += LEARNING_RATE * error * inputs[ i ];
        }
    }

    public void train( Trainer[] data ) {
        for ( int i = 0; i < EPOCHS; i++ ) {
            for ( Trainer instance : data ) {
                train( instance.getInputs(), instance.getAnswer() );
            }
        }
    }
}
