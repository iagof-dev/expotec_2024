char last_cmd = "-1";

//PINOS
int LED_R = 2;
int LED_G = 3;
int LED_O = 4;

int buzzer = 5;

int final_delay = 300;

void setup()
{
  Serial.begin(9600);
  pinMode(LED_R, OUTPUT);
  pinMode(LED_G, OUTPUT);
  pinMode(LED_O, OUTPUT);
  pinMode(buzzer, OUTPUT);

  // Desligar tudo
  digitalWrite(2, LOW);
  digitalWrite(3, LOW);
  digitalWrite(4, LOW);
}

void loop()
{
  if (Serial.available() > 0)
  {
    char command = Serial.read();
    last_cmd = command;
    while (Serial.available() > 0)
    {
      Serial.read();
    }
  }

  switch (last_cmd)
  {
    case 'D': //DISABLE ALL
      digitalWrite(LED_R, LOW);
      digitalWrite(LED_O, LOW);
      digitalWrite(LED_G, LOW);
      final_delay = 300;
      break;
    
    case 'W': //WIN
      final_delay = 20;
      digitalWrite(LED_G, HIGH);
      tone(buzzer, 950, 150);
      break;

    case 'S': //SO CLOSE
      digitalWrite(LED_R, HIGH);
      digitalWrite(LED_G, HIGH);
      digitalWrite(LED_O, HIGH);
      tone(buzzer, 950, 150);
      delay(100);
      digitalWrite(LED_R, LOW);
      digitalWrite(LED_O, LOW);
      digitalWrite(LED_G, LOW);
      delay(50);
      break;
    case 'C': //CLOSE
      digitalWrite(LED_G, HIGH);
      tone(buzzer, 950, 300);
      delay(200);
      digitalWrite(LED_G, LOW);
      delay(100);
      break;
    case 'M': //MEDIUM
      digitalWrite(LED_O, HIGH);
      tone(buzzer, 950, 300);
      delay(400);
      digitalWrite(LED_O, LOW);
      delay(300);
      break;
      
    case 'F': // FAR
      digitalWrite(LED_R, HIGH);
      delay(850);
      digitalWrite(LED_R, LOW);
      break;

    case 'T': //teste
      digitalWrite(LED_R, HIGH);
      digitalWrite(LED_O, HIGH);
      digitalWrite(LED_G, HIGH);
      break;
    case 'Z':
      digitalWrite(LED_R, HIGH);
      delay(500);
      digitalWrite(LED_R, LOW);
      delay(500);
      digitalWrite(LED_O, HIGH);
      delay(500);
      digitalWrite(LED_O, LOW);
      delay(500);
      digitalWrite(LED_G, HIGH);
      delay(500);
      digitalWrite(LED_G, LOW);
      delay(500);
      tone(buzzer, 950, 50);
      delay(500);
      last_cmd = '-1';
      break;

  }
  delay(final_delay);
}
