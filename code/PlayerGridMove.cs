using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerGridMove : MonoBehaviour
{
    public float speed;
    public int moveSpaces;
    public float gridOffset;
    public Text moveDisplay;

    public Flag flag;

    private bool _moving;
    private List<Vector3> _undo;
    private Vector3 _targetPos;
    private Vector3 _movement;
    private float _gravity;
    private int _movesLeft;
    private CharacterController _controller;

    // Start is called before the first frame update
    void Start()
    {
        _controller = GetComponent<CharacterController>();
        _gravity = 9.8f;
        _movesLeft = moveSpaces;
        _movement = new Vector3();
        moveDisplay.text = "Moves Left: " + _movesLeft;
        _undo = new List<Vector3>();
    }

    private bool CheckPath(Vector3 direction)
    {
        RaycastHit hit;
        if (Physics.Raycast(transform.position, direction, out hit, gridOffset))
        {
            if (hit.collider.gameObject.CompareTag("Flag"))
            {
                //Ooh the flag, wonder how you get it? 
                flag.GetFlag();
            }

            return false;
        }
        return true;
    }

    // Update is called once per frame
    void Update()
    {
        if (!_moving && _movesLeft > 0 && _controller.isGrounded)
        {
            //Arrow Keys Input
            float x = Input.GetAxisRaw("Horizontal");
            float z = Input.GetAxisRaw("Vertical");
            
            if (x != 0.0f)
            {
                if (CheckPath(Vector3.right * x))
                {
                    _undo.Add(transform.position);
                    _targetPos = transform.position;
                    _targetPos.x += x * gridOffset;
                    _moving = true;
                    SetMoves(_movesLeft);
                }
            }
            else if (z != 0.0f)
            {
                if (CheckPath(Vector3.forward * z))
                {
                    _undo.Add(transform.position);
                    _targetPos = transform.position;
                    _targetPos.z += z * gridOffset;
                    _moving = true;
                    SetMoves(_movesLeft);
                }
            }
        }
        else if (_moving)
        {
            Vector3 direction = _targetPos - transform.position;
            if (direction.magnitude <= 0.1f)
            {
                transform.position = _targetPos;
                _moving = false;

                _movement.x = 0.0f;
                _movement.z = 0.0f;
                if (_movesLeft == 0)
                {
                    GetComponent<GridTurn>().MenuOpen();
                }
            }
            else
            {
                direction.Normalize();
                direction *= speed;
                _movement.x = direction.x;
                _movement.z = direction.z;
            }
        }

        if (!_moving && Input.GetButtonDown("Undo") && _undo.Count > 0) //Z Button Input
        {
            _targetPos = _undo[_undo.Count - 1];
            _moving = true;

            _undo.RemoveAt(_undo.Count - 1);

            SetMoves(_movesLeft + 1);
        }

        if (!_controller.isGrounded)
        {
            _movement.y -= _gravity * Time.deltaTime;
        }
        if (_moving || !_controller.isGrounded)
        {
            _controller.Move(_movement * Time.deltaTime);
        }
    }

    public void SetMoves(int spaces)
    {
        _movesLeft = spaces;
        moveDisplay.text = "Moves Left: " + _movesLeft;

    }
}