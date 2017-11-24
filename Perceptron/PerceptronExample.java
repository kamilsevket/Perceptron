package perceptron;



/**
 *
 * @author Kamil Demirtaş
 */
public class PerceptronExample {
    private static final int NUMBER_OF_DATA_POINTS = 5;

    public static double f( double x ) {
        return x / 2 + 1;
    }
     
    public static void main( String[] args ) {
    	
    	double inputsAnd[][] = {{0,0},{0,1},{1,0},{1,1}};
        int outputsAnd[] = {0,0,0,1};
        
        double inputsOr[][] = {{0,0},{0,1},{1,0},{1,1}};
        int outputsOr[] = {0,1,1,1};
        

        double inputsNot[] = {0,1};
        int outputsNot[] = {1,0};
  

        
        Trainer[] trainingAnd = new Trainer[NUMBER_OF_DATA_POINTS];
        Trainer[] trainingOr = new Trainer[NUMBER_OF_DATA_POINTS];
        Trainer[] trainingNot = new Trainer[NUMBER_OF_DATA_POINTS];


        double x = 0;
        double y = 0;
        int answer = 0;
        
        for ( int i = 0; i < trainingAnd.length; i++ ) {
            for(int j = 0; j < inputsAnd.length; j++) {
            	x = inputsAnd[j][0];
            	y = inputsAnd[j][1];
            	answer = outputsAnd[j];
            }
            trainingAnd[ i ] = new Trainer( x, y, answer );
        }

        for ( int i = 0; i < trainingOr.length; i++ ) {
            for(int j = 0; j < inputsOr.length; j++) {
            	x = inputsOr[j][0];
            	y = inputsOr[j][1];
            	answer = outputsOr[j];
            }
            trainingOr[ i ] = new Trainer( x, y, answer );
        }

        for ( int i = 0; i < trainingNot.length; i++ ) {
            for(int j = 0; j < inputsNot.length; j++) {
            	x = inputsNot[j];
            	answer = outputsNot[j];
            }
            trainingNot[ i ] = new Trainer( x, answer );
        }

        Perceptron ptronAnd = new Perceptron(3);
        Perceptron ptronOr = new Perceptron(3);
        Perceptron ptronNot = new Perceptron(2);

        ptronAnd.train( trainingAnd);
        ptronOr.train(trainingOr );
        ptronNot.train(trainingNot);
        
        System.out.println("Last Weights of AND Gates");
        System.out.println(ptronAnd.weights[0]);
        System.out.println(ptronAnd.weights[1]);
        System.out.println(ptronAnd.weights[2]);
        System.out.println("  ");
        System.out.println("--------------------------");
        System.out.println("Last Weights of OR Gates");
        System.out.println(ptronOr.weights[0]);
        System.out.println(ptronOr.weights[1]);
        System.out.println(ptronOr.weights[2]);
        
        double guessRateAnd = (ptronAnd.correct / 50000.0)*100;
        double guessRateOr = (ptronOr.correct / 50000.0)*100;
        double guessRateNot = (ptronNot.correct / 50000.0)*100;
        
        System.out.println("Guess Rate of AND Gate : %" + guessRateAnd);
        System.out.println("Guess Rate of OR Gate : %" + guessRateOr);
        System.out.println("Guess Rate of Not Gate : %" + guessRateNot);
    }
}
