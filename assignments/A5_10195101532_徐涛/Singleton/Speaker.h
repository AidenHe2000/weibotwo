//
// Created by Admin on 2021/4/25.
//

#ifndef MAIN_CPP_SPEAKER_H
#define MAIN_CPP_SPEAKER_H

class Speaker {
    static Speaker *singleton;

    Speaker() = default;

public:
    static const Speaker &getInstance();

    void speak() const;
};

#endif //MAIN_CPP_SPEAKER_H
