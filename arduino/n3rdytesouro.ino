void setup() {
  Serial.begin(9600);
  pinMode(5, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);

  // Desliga todos os pinos no início
  digitalWrite(2, LOW);
  digitalWrite(3, LOW);
  digitalWrite(4, LOW);
}

void loop() {
  if (Serial.available() > 0) {
    char command = Serial.read();

    // Limpa o buffer serial para garantir que apenas o último comando seja lido
    while(Serial.available() > 0) {
      Serial.read();
    }

    if (command != ' ' && command != -1) {
      Serial.print("Comando:");
      Serial.print(command);
      Serial.println(" ");
    }

    digitalWrite(2, LOW);
    digitalWrite(3, LOW);
    digitalWrite(4, LOW);

    if(command == '1') {
      digitalWrite(4, HIGH);
      digitalWrite(3, HIGH);
      digitalWrite(2, HIGH);
      tone(5, 950, 300);
      delay(200);
      digitalWrite(4, LOW);
      digitalWrite(3, LOW);
      digitalWrite(2, LOW);
      delay(100);
    } else if(command == '2') {
      digitalWrite(4, HIGH);
      tone(5, 950, 300);
      delay(400);
      digitalWrite(4, LOW);
      delay(300);
    } else if(command == '3') {
      digitalWrite(3, HIGH);
      tone(5, 950, 300);
      delay(1000);
      digitalWrite(3, LOW);
    } else if(command == '4') {
      digitalWrite(2, HIGH);
      delay(1500);
      digitalWrite(2, LOW);
    } else if(command == 'T') {
      digitalWrite(4, HIGH);
      digitalWrite(3, HIGH);
      digitalWrite(2, HIGH);
    }else if(command == 'DA'){
      digitalWrite(4, LOW);
      digitalWrite(3, LOW);
      digitalWrite(2, LOW);
    }
    delay(500);
  }
}
