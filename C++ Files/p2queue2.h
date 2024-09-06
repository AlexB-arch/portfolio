const int SIZE = 5;
	
template <typename T>
struct Queue {
   T   data[SIZE];
   int head;
   int tail;
};

template <typename T>
void initialize(Queue<T>& QueueTwo){
   QueueTwo.head = 0;
   QueueTwo.tail = 0;
   //Initializes the queue using the standard library format at zero.
}

template <typename T>
void destroy(Queue<T>& QueueTwo){
   QueueTwo.head = 0;
   QueueTwo.tail = 0;
   //Resets the queue back to zero.
}

template <typename T>
int  getSize(Queue<T> QueueTwo){

   int counter = 0;

   if(QueueTwo.tail < QueueTwo.head){
      counter = (SIZE - 1) - QueueTwo.head + (QueueTwo.tail + 1);
   }
   else if(QueueTwo.tail > QueueTwo.head){
      counter = QueueTwo.tail - QueueTwo.head;
   }
   if(counter < 0){
      counter *= -1;
   }

   return counter;
}

template <typename T>
bool isEmpty(Queue<T> QueueTwo){

   return QueueTwo.head == QueueTwo.tail;
}

template <typename T>
void push(Queue<T>& QueueTwo, T pushSomething ){

   QueueTwo.data[QueueTwo.tail] = pushSomething;
   QueueTwo.tail++;

   if(QueueTwo.tail > SIZE - 1){

      QueueTwo.tail = 0;
   }
}

template <typename T>
T    pop(Queue<T>& QueueTwo){

   T popSomething = QueueTwo.data[QueueTwo.head];
   QueueTwo.head++;

   if(QueueTwo.head > SIZE -1){
      
      QueueTwo.head = 0;
   }

   return popSomething;
}	