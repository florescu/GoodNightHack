import processing.serial.*;

#define Vref 4.95

float average;
float sum;
int index;
int sensorValue;
PrintWriter output;

void setup() {
  // put your setup code here, to run once:
   Serial.begin(9600);
   output = createWriter("gasSensorValue.txt");
}

void loop() {
  // put your main code here, to run repeatedly:
  float vol;
  //gas density.
  sensorValue = analogRead(A0);
  vol = (float) sensorValue/1023*4.95*0.21;
  Serial.print("The voltage is ");
  Serial.println(vol);
  Serial.print("Sensor reading ");
  Serial.println(sensorValue);
  index = index + 1;
  myFile = SD.open
  if (index > 500)
  {
    sum = sum + sensorValue;
  }
  if (index == 1000)
  {
    average = sum / index;  
    output.println(average);
    output.flush();
    output.close();
    exit();
  }
  delay(100);
}
