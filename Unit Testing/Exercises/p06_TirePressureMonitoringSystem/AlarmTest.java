package p06_TirePressureMonitoringSystem;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void testAlarmWithLowPressure() {
        Sensor sensorLowPressure = Mockito.mock(Sensor.class);
        when(sensorLowPressure.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensorLowPressure);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHighPressure() {
        Sensor sensorHighPressure = Mockito.mock(Sensor.class);
        when(sensorHighPressure.popNextPressurePsiValue()).thenReturn(50.0);
        Alarm alarm = new Alarm(sensorHighPressure);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmNormalPressure() {
        Sensor sensorNormalPressure = Mockito.mock(Sensor.class);
        when(sensorNormalPressure.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensorNormalPressure);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}