package tourino.adrian.monkeyfilmapp.login.domain

import tourino.adrian.monkeyfilmapp.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String) : Boolean {
        return repository.doLogin(user, password)
    }
}