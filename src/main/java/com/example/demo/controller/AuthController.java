@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        return authService.login(user);
    }
}
