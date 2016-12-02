package billingService.ws;

import javax.jws.WebService;
import java.util.Objects;


/**
 * Created by fernandomelone on 11/30/16.
 */

//Service Implementation
@WebService(endpointInterface = "billingService.ws.Bill")
public class BillImplService implements Bill {
    public Status process(Bill_Type billData) {
        Status statusResult = new Status();

        try {
            if (billData.id>1000 && billData.id<10000){ // Arbitrary range of valid IDs (which would make sense in a real business scenario)
                Thread.sleep((long)(Math.random() * 5000)); // Generate a random sleep to simulate async processing time (so the queue integration makes sense)
                statusResult.statusCode="Success";
                statusResult.statusMessage="The Bill with ID " + billData.id + " was successfully processed";
            }else{
                if (Objects.nonNull(billData)){ // If it fails as it is not within the valid range, and it has valid data, then returns a Failed message
                    statusResult.statusCode="Failed";
                    statusResult.statusMessage="The Bill ID " + billData.id + " is not within a valid range";
                }else{
                    throw new Exception("Please provide a valid Bill Data Structure"); // If is does not contain valid data, or other errors occur, then it is an error
                }
            }
        }catch (Exception e){
            statusResult.statusCode="Error";
            statusResult.statusMessage=e.toString();
        }

        return statusResult;
    }
}
