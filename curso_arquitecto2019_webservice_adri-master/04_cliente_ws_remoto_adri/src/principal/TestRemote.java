package principal;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axis.types.UnsignedLong;

import com.dataaccess.www.webservicesserver.NumberConversionSoapType;
import com.dataaccess.www.webservicesserver.NumberConversionSoapTypeProxy;

public class TestRemote {

	public static void main(String[] args) throws NumberFormatException, RemoteException {
		NumberConversionSoapType px;
		NumberConversionSoapTypeProxy proxy= new NumberConversionSoapTypeProxy();
		px=proxy.getNumberConversionSoapType();
		System.out.println(px.numberToDollars(new BigDecimal(40)));
		System.out.println(px.numberToWords(new UnsignedLong(445550092)));

	}

}
